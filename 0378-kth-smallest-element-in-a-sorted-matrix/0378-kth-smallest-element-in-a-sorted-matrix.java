class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;
        int m = matrix[0].length;

        int low = matrix[0][0];
        int high = matrix[n -1][m -1];   

        while(low <= high){
            int mid = low + (high -low)/2;

            int ans = isPresent(matrix,mid);
            if(ans < k){ 
                low = mid +1;
            } else{
                high = mid -1;
            }
        }
        return low;
    }
    //Check how many less then element are present
    public int isPresent(int[][] matrix, int mid){

        int n = matrix.length;
        int m = matrix[0].length;

        int row = n -1;
        int cols = 0;
        int count = 0;
        while(row >= 0 && cols < m){
            if(matrix[row][cols] <= mid){
                count += row +1;
                cols++;
            } else {
                row--;
            }
        }
        return count;
    }
}