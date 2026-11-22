class Solution {
    public boolean checkString(String s) {
        int i=0;
        int n=s.length();
        while(i<n){
            if(s.charAt(i)!='a'){
                while(i<n){
                    if(s.charAt(i)=='a'){
                        return false;
                    }
                    i++;
                }
            }
            i++;
        }
        return true;
    }
}