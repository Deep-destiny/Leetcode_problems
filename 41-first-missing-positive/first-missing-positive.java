class Solution {
    public int firstMissingPositive(int[] nums) {
        // bs faileed
        Arrays.sort(nums);
  int expected = 1;
        for (int num : nums) {
            if (num == expected) {
                expected++;
            }
            else if (num > expected) {
                return expected;
            }
        }
return expected;
    }
}