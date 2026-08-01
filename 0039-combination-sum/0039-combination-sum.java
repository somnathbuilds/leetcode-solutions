class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0, new ArrayList<>());
        return ans;
    }

    private void backtrack(int[] candidates, int target, int index, List<Integer> curr) {

        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (index == candidates.length || target < 0) {
            return;
        }

        // Take current element
        curr.add(candidates[index]);
        backtrack(candidates, target - candidates[index], index, curr);
        curr.remove(curr.size() - 1);

        // Skip current element
        backtrack(candidates, target, index + 1, curr);
    }
}