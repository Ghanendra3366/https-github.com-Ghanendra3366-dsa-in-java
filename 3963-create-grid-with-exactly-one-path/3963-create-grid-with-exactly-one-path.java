public class Solution {
    public String[] createGrid(int m, int n) {
        String[][] arr = new String[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(arr[i], "#");
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == n - 1) {
                    arr[i][j] = ".";
                }
            }
        }
        
        String[] result = new String[m];
        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]);
            }
            result[i] = sb.toString();
        }
        
        return result;
    }
}
