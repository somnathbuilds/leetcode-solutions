class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if(target < matrix[0][0] || target > matrix[rows -1][cols -1]){
            return false;
        } 
        int low = 0;
        int high = rows * cols -1;

        while(low <= high){
            int mid = low + (high - low)/2;

            int row = mid / cols;
            int col = mid % cols;

            if(target == matrix[row][col]){
                return true;
            } else if(target > matrix[row][col]){
                low = mid +1;
            } else{
                high = mid -1;
            }
        }
        return false;
    }
}