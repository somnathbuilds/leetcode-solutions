class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        solve(1, k, n, temp, ans);

        return ans;
    }

    void solve(int start, int k, int target,
               List<Integer> temp,
               List<List<Integer>> ans) {

        // Exactly k numbers choose ho gaye
        if (temp.size() == k) {
            if (target == 0) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        // 1 se 9 tak numbers try karo
        for (int i = start; i <= 9; i++) {

            // Agar i target se bada hai,
            // aage ke numbers bhi bade honge
            if (i > target)
                break;

            // Choose
            temp.add(i);

            // i + 1 se start -> same number dobara nahi aayega
            solve(i + 1, k, target - i, temp, ans);

            // Backtrack
            temp.remove(temp.size() - 1);
        }
    }
}