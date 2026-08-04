class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        int win= nums[n-1]-nums[0]-1;
        int i=1;
        int j=1;
        while(j<=win ){
            if(nums[0]+j!=nums[i]){
                ans.add(nums[0]+j);
                j++;
            }
            else {
                i++;
                j++;
            }
        }
        return ans;
    }
}