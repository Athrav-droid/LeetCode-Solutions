class Solution {
    public String largestNumber(int[] nums) {
        String[] copy = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            copy[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(copy,(a,b) -> (b+a).compareTo(a+b)); // sorting ka sara khel comparator ka h .. is function ki complexity O(nlogn) h.
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<copy.length;i++){
            sb.append(copy[i]);
        }    
        if(sb.charAt(0) == '0') return "0";
        String ans = sb.toString();
        return ans;
    }
}