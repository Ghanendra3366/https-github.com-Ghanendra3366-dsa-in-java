// class Solution {
//     public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
//         int[][] arr = new int[n+1][11];
        
//         int m=reservedSeats.length;
//         for(int[] point : reservedSeats){
//             int x=point[0];
//             int y=point[1];
//             arr[x][y]=1;
//         }
//         int c=0;
//         int count=0;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 if(arr[i][j]==0){
//                     c+=1;
//                 }
//                 else{
//                     c=0;
//                 }
//                 if(c ==4){
//                     count+=1;
//                     c=0;
//                 }

//             }
//         }
//         return count;
//     }
// }
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> reserved = new HashMap<>();

        for (int[] seat : reservedSeats) {
            reserved
                .computeIfAbsent(seat[0], k -> new HashSet<>())
                .add(seat[1]);
        }

        int count = (n - reserved.size()) * 2;

        for (Map.Entry<Integer, Set<Integer>> entry : reserved.entrySet()) {
            Set<Integer> seats = entry.getValue();

            boolean left = true; 
            boolean middle = true; 
            boolean right = true;  

            for (int seat = 2; seat <= 5; seat++) {
                if (seats.contains(seat)) {
                    left = false;
                    break;
                }
            }

            for (int seat = 4; seat <= 7; seat++) {
                if (seats.contains(seat)) {
                    middle = false;
                    break;
                }
            }

            for (int seat = 6; seat <= 9; seat++) {
                if (seats.contains(seat)) {
                    right = false;
                    break;
                }
            }

            if (left && right) {
                count += 2;
            } else if (left || middle || right) {
                count += 1;
            }
        }

        return count;
    }
}