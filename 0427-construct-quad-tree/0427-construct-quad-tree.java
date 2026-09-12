/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {

    public Node construct(int[][] grid) {
        return solve(grid, 0, 0, grid.length);
    }

    private Node solve(int[][] grid, int row, int col, int size) {

        // Check whether current square has same values
        boolean same = true;

        int value = grid[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {

                if (grid[i][j] != value) {
                    same = false;
                    break;
                }
            }

            if (!same) {
                break;
            }
        }

        // If all values are same → leaf node
        if (same) {
            return new Node(value == 1, true);
        }

        // Otherwise divide into 4 parts
        int half = size / 2;

        Node topLeft = solve(grid, row, col, half);

        Node topRight = solve(grid, row, col + half, half);

        Node bottomLeft = solve(grid, row + half, col, half);

        Node bottomRight = solve(grid, row + half, col + half, half);

        // Internal node
        return new Node(
            true,
            false,
            topLeft,
            topRight,
            bottomLeft,
            bottomRight
        );
    }
}