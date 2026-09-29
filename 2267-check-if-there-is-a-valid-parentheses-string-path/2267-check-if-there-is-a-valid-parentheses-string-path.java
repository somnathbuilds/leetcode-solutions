class Solution {
    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // Length of every path
        int len = m + n - 1;

        // Valid parentheses string must have even length
        if (len % 2 == 1) {
            return false;
        }

        // Starting with ')' is impossible
        if (grid[0][0] == ')') {
            return false;
        }

        // dp[i][j][balance]
        boolean[][][] dp = new boolean[m][n][len + 1];

        dp[0][0][1] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // Starting cell already initialized
                if (i == 0 && j == 0) {
                    continue;
                }

                for (int balance = 0; balance <= len; balance++) {

                    char ch = grid[i][j];

                    int newBalance;

                    if (ch == '(') {
                        newBalance = balance + 1;
                    } else {
                        newBalance = balance - 1;
                    }

                    // Balance cannot be negative
                    if (newBalance < 0) {
                        continue;
                    }

                    // Come from top
                    if (i > 0 && dp[i - 1][j][balance]) {
                        dp[i][j][newBalance] = true;
                    }

                    // Come from left
                    if (j > 0 && dp[i][j - 1][balance]) {
                        dp[i][j][newBalance] = true;
                    }
                }
            }
        }

        // At the end balance must be 0
        return dp[m - 1][n - 1][0];
    }
}

