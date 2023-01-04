class Solution {
    //https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/solutions/2779140/minimum-rounds-to-complete-all-tasks/
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> countTasks= new HashMap<Integer,Integer>();
        for(int a: tasks){
            if(countTasks.containsKey(a)) countTasks.put(a,countTasks.get(a)+1);
            else countTasks.put(a,1);
        }
        int Rounds=0;
        for(int a: countTasks.values()){
            if(a == 1) return -1;
            if(a%3==0){
                Rounds += a/3;
            }else{
                Rounds += a/3+1;
            }
        }
        return Rounds;
    }
}