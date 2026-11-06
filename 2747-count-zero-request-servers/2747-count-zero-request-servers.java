class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = queries.length;
        int[] result = new int[m];
        int[][] sortedQueries = new int[m][2];
        
        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] serverCounts = new int[n + 1];
        int uniqueServersWithRequests = 0;
        int left = 0;
        int right = 0;
        
        for (int i = 0; i < m; i++) {
            int queryTime = sortedQueries[i][0];
            int originalIndex = sortedQueries[i][1];
            
            while (right < logs.length && logs[right][1] <= queryTime) {
                int serverId = logs[right][0];
                if (serverCounts[serverId] == 0) {
                    uniqueServersWithRequests++;
                }
                serverCounts[serverId]++;
                right++;
            }
            
            int startTime = queryTime - x;
            while (left < logs.length && logs[left][1] < startTime) {
                int serverId = logs[left][0];
                serverCounts[serverId]--;
                if (serverCounts[serverId] == 0) {
                    uniqueServersWithRequests--;
                }
                left++;
            }
            
            result[originalIndex] = n - uniqueServersWithRequests;
        }
        
        return result;
    }
}
