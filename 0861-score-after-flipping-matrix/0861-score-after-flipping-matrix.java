class Solution {
    public int matrixScore(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // Step 1: Make first column of every row 1
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {

                for (int j = 0; j < n; j++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }

        // Step 2: For every remaining column,
        // make number of 1s maximum
        for (int j = 1; j < n; j++) {

            int ones = 0;

            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    ones++;
                }
            }

            int zeros = m - ones;

            if (zeros > ones) {

                for (int i = 0; i < m; i++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }

        // Step 3: Calculate score
        int score = 0;

        for (int i = 0; i < m; i++) {

            int num = 0;

            for (int j = 0; j < n; j++) {
                num = num * 2 + grid[i][j];
            }

            score += num;
        }

        return score;
    }
}