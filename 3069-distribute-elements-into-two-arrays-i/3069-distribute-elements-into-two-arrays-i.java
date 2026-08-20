class Solution {
    public int[] resultArray(int[] nums) {
        Stack<Integer> arr1 =new Stack<>();
        Stack<Integer> arr2 =new Stack<>();
        arr1.push(nums[0]);
        arr2.push(nums[1]);
        for(int i=2;i<nums.length;i++){
            if(arr1.peek()>=arr2.peek()){
                arr1.push(nums[i]);

            }
            else{
                arr2.push(nums[i]);
            }
        }
        int[] res =new int[nums.length];
        int i=nums.length-1;
        while(!arr2.isEmpty() ){
            res[i]=arr2.pop();
            i--;
        }
        while(!arr1.isEmpty() ){
            res[i]=arr1.pop();
            i--;
        }
        return res;
    }
}