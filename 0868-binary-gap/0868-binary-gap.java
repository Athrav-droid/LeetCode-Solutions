class Solution {
    public int binaryGap(int n) {
        int count = 0;
        ArrayList<Integer> binary = new ArrayList<>(convertToBinary(n));
        ArrayList<Integer> helper = new ArrayList<>();
        for(int i=0;i<binary.size();i++){
            if(1 == binary.get(i)) count++;
        }
        if(count<=1) return 0;
        count = 0;
        for(int i=0;i<binary.size();i++){
            if(1 == binary.get(i)){
                helper.add(count);
                count = 0;
            } 
            count++;
        }
        return Collections.max(helper);
    }
    public ArrayList<Integer> convertToBinary(int n){
        ArrayList<Integer> helper = new ArrayList<>();
        for(int i=n;i>0;i/=2){
            helper.add(n%2);
            n/=2;
        }
        Collections.reverse(helper);
        System.out.println(helper);
        return helper;
    }
}