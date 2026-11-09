class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        PriorityQueue<int[]> busy = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        TreeSet<Integer> free = new TreeSet<>();
        for (int i = 0; i < k; ++i) {
            free.add(i);
        }
        
        int[] count = new int[k];
        int maxCount = 0;
        
        for (int i = 0; i < arrival.length; ++i) {
            int time = arrival[i];
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                free.add(busy.poll()[1]);
            }
            
            if (free.isEmpty()) {
                continue;
            }
            
            Integer server = free.ceiling(i % k);
            if (server == null) {
                server = free.first();
            }
            
            free.remove(server);
            busy.offer(new int[] { time + load[i], server });
            count[server]++;
            maxCount = Math.max(maxCount, count[server]);
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            if (count[i] == maxCount) {
                result.add(i);
            }
        }
        
        return result;
    }
}
