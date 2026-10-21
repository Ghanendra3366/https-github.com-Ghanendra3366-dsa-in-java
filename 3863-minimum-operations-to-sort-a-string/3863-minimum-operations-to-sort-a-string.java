class Solution {
    public int minOperations(String s) {
        char[] arr = s.toCharArray();
        boolean sorted = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                sorted = false;
                break;
            }
        }
        if (sorted) return 0;
        int n = arr.length;
        if (n == 2) return -1;
        char mn = arr[0], mx = arr[0];
        for (char c : arr) {
            if (c < mn) mn = c;
            if (c > mx) mx = c;
        }
        if (arr[0] == mn || arr[n - 1] == mx) return 1;
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] == mn || arr[i] == mx) return 2;
        }
        return 3;
    }
}
