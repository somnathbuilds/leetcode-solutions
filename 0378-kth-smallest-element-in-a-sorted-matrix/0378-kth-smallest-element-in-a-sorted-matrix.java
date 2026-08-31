class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = matrix[0][0];
        int high = matrix[n-1][m-1];

        while(low <= high){
            int mid = low + (high -low)/2;

            int ans = smaller(matrix, mid);
            if(ans < k){
                low = mid +1;
            } else{
                high = mid -1;
            }
        }
        return low;
    }
    public int smaller(int[][] matrix, int mid){
        int m = matrix.length;
        int n = matrix[0].length;

        int row = m -1;
        int col = 0;
        int count = 0;

        while(row >= 0 && col < n){
            if(matrix[row][col] <= mid){
                count += row +1;
                col++;
            } else{
                row--;
            }
        }
        return count;
    }
}