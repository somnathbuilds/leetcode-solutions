/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        boolean nullFound = false;

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr == null) {
                nullFound = true;
            } else {
                // Agar pehle hi NULL mil chuka hai,
                // aur ab non-null node mil rahi hai,
                // to tree complete nahi hai.
                if (nullFound) {
                    return false;
                }

                q.add(curr.left);
                q.add(curr.right);
            }
        }

        return true;
    }
}