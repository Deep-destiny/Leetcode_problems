class Solution {
    public boolean partitionArray(int[] nums, int k) {
// 1. Check if we can form equal-sized groups
int n=nums.length;
        if (n % k != 0) {
            return false;
        }
        
        // Calculate exactly how many groups we have
        int totalGroups = n / k;
        
        // 2. Build the frequency map using a raw array for maximum speed
        // The array size is 100001 to safely cover the constraint nums[i] <= 10^5
        int[] freq = new int[100001];
        
        for (int num : nums) {
            freq[num]++;
            
            // 3. The Pigeonhole Check
            // The millisecond any number's frequency exceeds the total number of groups, 
            // it is mathematically impossible to avoid duplicates.
            if (freq[num] > totalGroups) {
                return false;
            }
        }
        
        // If we processed the whole array and no frequency broke the ceiling, it's possible!
        return true;
    }
}