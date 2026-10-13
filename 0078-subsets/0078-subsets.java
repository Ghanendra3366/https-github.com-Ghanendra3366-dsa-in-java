class Solution {
    private void dfs(int[] nums, int i, List<Integer> path, List<List<Integer>> out) {
        if (i == nums.length) {
            out.add(new ArrayList<>(path));
            return;
        }
        dfs(nums, i + 1, path, out);
        path.add(nums[i]);
        dfs(nums, i + 1, path, out);
        path.remove(path.size() - 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), out);
        return out;
    }
}