class Solution {
    int n;
    int[][]dp;
       private int findMethod(int[] nums, int start, int target) {
        int lo = start, hi = n; // search in [start, n)
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        if (lo < n && nums[lo] == target) {
            return lo;
        }

        return -1;
    }


    int solve(int i,int inc,int[] nums){
        if(dp[i][inc]!=-1) return dp[i][inc];
        int currVal=nums[i]+inc;
        int len=1;
        // option1 : find  currval +1
        int j= findMethod(nums,i+1,currVal+1);
        if(j!=-1) len=Math.max(len,1+solve(j,0,nums));
        // option2: find currval and then inc by 1
        j= findMethod(nums,i+1,currVal);
        if(j!=-1) len=Math.max(len,1+solve(j,1,nums));

        return dp[i][inc]=len;
    }
    public int maxSelectedElements(int[] nums) {
          n=nums.length;
          Arrays.sort(nums);
          dp=new int[n+1][2];
          for(int []r:dp){
            Arrays.fill(r,-1);
          }
          int result=1;


          int res=-1;
          for(int i=0;i<n;i++){
            res=Math.max(res,Math.max(solve(i,0,nums),solve(i,1,nums)));
          }  
          return res;
    }
}