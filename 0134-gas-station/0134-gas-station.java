class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // CODE ATTEMPT ONE
        int n = gas.length;
        int gasSum = 0;
        int costSum = 0;
        for(int i=0;i<n;i++){
            gasSum+=gas[i];
            costSum+=cost[i];
        }
        if(gasSum < costSum) return -1;
        // agr solution exist nhi kr rha hoga to yha tk pta chl jayega
        costSum = 0;
        int idx = 0;
        //idhr se hum us first index/station ko return krenge jiske aage ke sabhi station visit safe h because we know ki solution exist kr rha h
        for(int i=0;i<n;i++){
            costSum += gas[i] - cost[i];
            if(costSum < 0){
                costSum = 0;
                idx = i+1;
            }
        }
        return idx;
        //CODE ATTEMPT TWO COPIED
    //     int gSum=0,idx=0,cSum=0;
    // for(int i=0;i<G.length;i++){
    //     gSum+=G[i];
    //     cSum+=C[i];
    // }
    // if(gSum<cSum) return -1;
    // cSum=0;
    // for(int i=0;i<G.length;i++){
    //     cSum+=G[i]-C[i];
    //     if(cSum<0){
    //         idx=i+1;
    //         cSum=0;
    //     }
    // }
    // return idx;
    //CODE ATTEMPT THREE it's wrong approach
        // int n = gas.length;
        // int gasSum = 0;
        // int costSum = 0;
        // int index = 0;
        // for(int i=0;i<n;i++){
        //     gasSum+=gas[i];
        //     costSum+=cost[i];
        // }
        // if(gasSum < costSum) return -1;
        // for(int i=0;i<n;i++){
        //     if(gas[i]>cost[i]){
        //         index = i;
        //         return index;
        //     }
        // }
        // return index;
    }
}