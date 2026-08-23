class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        boolean [] vis=new boolean[nums.length+1];
        Arrays.fill(vis,false);
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(vis[nums[i]]){
             res.add(nums[i]);
            }
            else{
                 vis[nums[i]]=true;
        }
        }
        return res;
    }
}