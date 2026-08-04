class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int rows = n -1;
        int cols = 0;
        while(rows >= 0 && cols < m){
            if(target == matrix[rows][cols]){
                return true;
            }else if(target < matrix[rows][cols]){
                rows--;
            } else {
                cols++;
            }
        }
        return false;
    }
}