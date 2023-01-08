class Solution {
    public boolean hasAlternatingBits(int n) {
        ArrayList<Integer> binary = new ArrayList<>(convertToBinary(n));
        int count1 = 0;
        int count0 = 0;
        if(binary.get(0) == 1) count1++;
        else count0++;
        for(int i=1;i<binary.size();i++){
            if(1 == binary.get(i)) count1+=2;
            if(0 == binary.get(i)) count0+=2;
            if(Math.abs(count0-count1) > 1) return false;
        }
        return true;
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