class Solution {
    public boolean canJump(int[] nums) {

        int idx = 0;
        int n = nums.length;

        if (n == 1) return true;

        int farthest = 0;

        while (idx < n) {

            if (idx > farthest) {
                return false;
            }

            farthest = Math.max(farthest, idx + nums[idx]);

            if (farthest >= n - 1) {
                return true;
            }

            idx++;
        }

        return false;
    }
}