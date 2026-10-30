class Solution {
    public int[] dailyTemperatures(int[] t) {
        int n = t.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && t[i] > t[st.peek()]) {
                int idx = st.pop();
                ans[idx] = i - idx;
            }
            st.push(i);
        }
        return ans;
    }
}
