class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] ans = new int[n];
        Arrays.sort(potions);
        for(int i = 0; i < n; i++){
            int index = binarySearch((long)spells[i], potions, success);
            ans[i] = index == m ? 0 : m - index;
        }
        return ans;
    }
    public int binarySearch(long spell, int[] potions, long success){
        int left = 0, right = potions.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(spell * potions[mid] < success) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}