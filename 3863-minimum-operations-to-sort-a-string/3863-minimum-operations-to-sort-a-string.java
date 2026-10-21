class Solution {
    public int minOperations(String s) {
        if (isSorted(s)) return 0;
        int n = s.length();
        if (n == 2) return -1;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(s);
        visited.add(s);
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                
                String next1 = sortSubstring(curr, 0, n - 2);
                if (isSorted(next1)) return steps;
                if (!visited.contains(next1)) {
                    visited.add(next1);
                    queue.offer(next1);
                }
                
                String next2 = sortSubstring(curr, 1, n - 1);
                if (isSorted(next2)) return steps;
                if (!visited.contains(next2)) {
                    visited.add(next2);
                    queue.offer(next2);
                }
            }
        }
        return -1;
    }

    private boolean isSorted(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private String sortSubstring(String s, int start, int end) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr, start, end + 1);
        return new String(arr);
    }
}
