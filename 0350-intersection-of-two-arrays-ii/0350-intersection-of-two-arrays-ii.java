class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0;
        int j=0;
        List<Integer>res=new ArrayList<>();
        while(i<n&&j<m){
            if(nums1[i]==nums2[j]){
                res.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i]<nums2[j]){
                i++;
            }
            else{
                j++;
            }
        }
        int[]arr=new int[res.size()];
        for(int a=0;a<res.size();a++){
            arr[a]=res.get(a);
        }
        return arr;
    }
}