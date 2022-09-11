// class Solution {
//     public List<Integer> spiralOrder(int[][] matrix) {
//         int rowStart = 0;
//         int colStart = 0;
//         int rowEnd = matrix.length-1;
//         int colEnd = matrix[0].length-1;
//         List<Integer> ans = new ArrayList<Integer>();
        
//         while(rowStart<=rowEnd&&colStart<=colEnd){
//             for(int col=colStart;col<=colEnd;col++){
//                 ans.add(matrix[rowStart][col]);
//             }
//             rowStart++;
//             for(int row=rowStart;row<=rowEnd;row++){
//                 ans.add(matrix[row][colEnd]);
//             }
//             colEnd--;
//             for(int col=colEnd;col>=colStart;col--){
//                 ans.add(matrix[rowEnd][col]);
//             }
//             rowEnd--;
//             for(int row=rowEnd;row>=rowStart;row--){
//                 ans.add(matrix[row][colStart]);
//             }
//             colStart++;
//         }
//         return ans;
//     }
// }
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> out=new ArrayList<>();
        int m=matrix.length;
        int n=matrix[0].length;
        int k=0;
        int l=0;
        while(k<m && l<n){
            //first row
            for(int i=l;i<n;i++){
                out.add(matrix[k][i]);
            }
            k++;
            for(int i=k;i<m;i++){
                out.add(matrix[i][n-1]);
            }
            n--;
            if(k<m){
            //left
            for(int i=n-1;i>=l;i--){
                out.add(matrix[m-1][i]);
            }
            m--;
            }
            
            //top
            if(l<n){
            for(int i=m-1;i>=k;i--){
                out.add(matrix[i][l]);
            }
            l++;
            }
        }
        return out;
    }
}