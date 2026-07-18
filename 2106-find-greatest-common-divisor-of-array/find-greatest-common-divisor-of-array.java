class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        return gcd(nums[0],nums[nums.length-1]);
    }
    private int gcd(int a,int b){
        if(a==0) return b;
        if(b==0) return a;
        return gcd(b,a%b);
        }
    }