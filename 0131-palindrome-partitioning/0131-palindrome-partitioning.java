import java.util.*;

class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();

        backtrack(s, 0, path, ans);

        return ans;
    }

    private void backtrack(String s, int index,
                           List<String> path,
                           List<List<String>> ans) {

        // Base case: poori string partition ho gayi
        if (index == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // index se har possible substring try karo
        for (int end = index; end < s.length(); end++) {

            String part = s.substring(index, end + 1);

            // Sirf palindrome substring ko choose karo
            if (isPalindrome(part)) {

                path.add(part);

                // Next remaining string ke liye recursion
                backtrack(s, end + 1, path, ans);

                // Backtracking
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}