import java.util.HashSet;

class Solution {
    public int findLUSlength(String a, String b) {
        // if (a.equals(b)) {
        //     return -1;
        // }
        // int c = 0;
        // char[] A = a.toCharArray();
        // char[] B = b.toCharArray();
        // HashSet<Character> arr = new HashSet<>();
        // for(int i = 0; i < A.length; i++){
        //     arr.add(A[i]);
        // }
        // for(int i = 0; i < B.length; i++) {
        //     if(!arr.contains(B[i])){
        //         c++; 
        //     }
        //     else{
        //         c = 0;
        //     }
        // }
        // return c;
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }
}
