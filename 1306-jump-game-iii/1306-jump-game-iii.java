class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int curr = q.poll();
                // Moving to the left side
                if(curr - arr[curr] >= 0){
                //if at any point value is equal to 0 then return true
                    if(arr[curr - arr[curr]] == 0) return true;
                    else if(arr[curr - arr[curr]] > 0) q.add(curr - arr[curr]);
                }
                // Moving to the right side
                if(curr + arr[curr] < arr.length){
                    //if at any point value is equal to 0 then return true
                    if(arr[curr + arr[curr]] == 0) return true;
                    else if(arr[curr + arr[curr]] > 0) q.add(curr + arr[curr]);
                }
                // Making the value negative or we can say visited 
                arr[curr] = -1;
            }
        }
        return false;
    }
}