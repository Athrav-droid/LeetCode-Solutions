class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if(n == 1) return 0; //Start index is the last index.
        if(arr[0] == arr[n-1]) return 1;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.computeIfAbsent(arr[i], v -> new ArrayList<>()).add(i);
        }

        int ans = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while(!q.isEmpty()){
            ans++;
            int size = q.size();
            while(size-->0){
                int curr = q.poll();
                
                if(curr - 1 >= 0 && map.containsKey(arr[curr - 1])){
                    q.add(curr - 1);
                }

                if(curr + 1 < n && map.containsKey(arr[curr + 1])){
                    if(curr+1 == n-1) return ans;
                    q.add(curr + 1);
                }

                if(map.containsKey(arr[curr])){
                    for(int key : map.get(arr[curr])){
                        if(key == n-1) return ans;
                        if(key != curr) q.add(key);
                    }
                }
                map.remove(arr[curr]);
            }
        }
        return ans;
    }
}