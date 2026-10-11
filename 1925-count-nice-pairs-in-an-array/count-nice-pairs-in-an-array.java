class Solution {
        final int MOD=1000000007;
    public int countNicePairs(int[] nums) {
        int n=nums.length;
        long cnt=0;
      Map<Integer,Integer> mp=new HashMap<>();
        for(int num:nums){
            int diff=num-rev(num);
            int freq=mp.getOrDefault(diff,0);
            cnt=(cnt+freq)%MOD;
            mp.put(diff,freq+1);
        }
        return (int)cnt;
    }

    private int rev(int num){
        int sum=0;
        while(num>0){
            sum=sum*10+(num%10);
            num/=10;
        }
        return sum;
    }
}