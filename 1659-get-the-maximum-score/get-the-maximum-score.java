class Solution {
    final int MOD = 1000000007;
    
    public int maxSum(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        // Upgraded to 'long' to prevent overflow during addition
        long res = 0;
        long score1 = 0;
        long score2 = 0;
        
        int i = 0, j = 0;
        while(i < m && j < n) {
            if(nums1[i] < nums2[j]) {
                score1 += nums1[i++];
            }
            else if(nums2[j] < nums1[i]) {
                score2 += nums2[j++];
            }
            else {
                res += Math.max(score1, score2) + nums1[i];
                i++;
                j++;
                score1 = 0;
                score2 = 0;
            }
        }

        while(i < m) {
            score1 += nums1[i++];
        }
        while(j < n) {
            score2 += nums2[j++];
        }
        
        // Safely calculate the final max, apply the modulo, then cast back to int
        return (int) ((Math.max(score1, score2) + res) % MOD);   
    }
}