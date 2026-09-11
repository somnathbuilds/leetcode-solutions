class Solution {
    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int i, int j) {

        // boundary check
        if (i < 0 || i >= grid.length ||
            j < 0 || j >= grid[0].length ||
            grid[i][j] == '0') {
            return;
        }

        // mark as visited
        grid[i][j] = '0';

        // up
        dfs(grid, i - 1, j);

        // down
        dfs(grid, i + 1, j);

        // left
        dfs(grid, i, j - 1);

        // right
        dfs(grid, i, j + 1);
    }
}