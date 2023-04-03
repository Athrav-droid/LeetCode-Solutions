class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // After sorting :- we are trying to pair the heaviest with the lightest otherwise heaviest can't be paired with anyone
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int ans = 0;
        while(i <= j){
            ans++;
            if(people[i] + people[j] <= limit) i++;
            j--;
        }
        return ans;
    }
}