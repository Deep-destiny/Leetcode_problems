class Solution {
    public int firstStableIndex(int[] nums, int k) {
        // score = max 0- i -  min i -n-1
        // index i is table if score <=k return i
        // else return -1
      int n=nums.length;
      for(int i=0;i<n;i++){
        int min=Arrays.stream(nums,i,n).min().getAsInt();
        int max=Arrays.stream(nums,0,i+1).max().getAsInt();
        int score=max-min;
        if(score <=k) return i;
      }

    return -1;
    }
}