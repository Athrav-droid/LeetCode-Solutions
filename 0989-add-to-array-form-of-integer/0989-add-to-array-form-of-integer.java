class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int carry = 0;
        List<Integer> ans = new ArrayList<>();
        int i = num.length - 1;
        while(i >= 0 || carry > 0 || k > 0){
            int toadd = k % 10 + carry + (i >= 0 ? num[i--] : 0);
            carry = toadd / 10;
            toadd = toadd % 10;
            k = k / 10;
            ans.add(0, toadd);
        }
        return ans;
    }
}