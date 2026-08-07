class Solution {

    public String smallestNumber(String num, long t) {
        int n = num.length();

        // Check if t has prime factors other than 2, 3, 5, 7
        long temp = t;
        for (int primeFact : new int[]{2, 3, 5, 7}) {
            while (temp % primeFact == 0) {
                temp /= primeFact;
            }
        }

        if (temp != 1) { // Contains prime factors > 7
            return "-1";
        }

        // Precompute remainingFactor[i] = factor remaining for t after taking i digits of num
        long[] remainingFactor = new long[n + 1];
        remainingFactor[0] = t;

        for (int i = 0; i < n; i++) {
            int digit = num.charAt(i) - '0';

            if (digit == 0) {
                break;
            }

            remainingFactor[i + 1] = remainingFactor[i] / gcd(remainingFactor[i], digit);
        }

        // If the original input num is already sufficient
        if (remainingFactor[n] == 1) {
            return num;
        }

        int zeroPos = num.indexOf('0');
        int zeroIdx = (zeroPos != -1) ? zeroPos : n - 1;

        // Try replacing digits from right to left
        for (int i = zeroIdx; i >= 0; i--) {
            long required = remainingFactor[i];
            int freeSlots = n - 1 - i;

            for (int digit = (num.charAt(i) - '0') + 1; digit <= 9; digit++) {
                long furtherRequired = required / gcd(required, digit);
                String requiredNumber = freeSlotsFiller(furtherRequired, freeSlots);

                if (requiredNumber.length() == freeSlots) {
                    return num.substring(0, i) + (char) (digit + '0') + requiredNumber;
                }
            }
        }

        // Expand to n + 1 digits if no valid prefix works
        return freeSlotsFiller(t, n + 1);
    }

    // Smallest zero-free number of length at least "length" divisible by "required"
    private String freeSlotsFiller(long required, int length) {
        StringBuilder str = new StringBuilder();

        for (int digit = 9; digit >= 2; digit--) {
            while (required % digit == 0) {
                str.append((char) (digit + '0'));
                required /= digit;
            }
        }

        while (str.length() < length) { // Pad with 1s
            str.append('1');
        }

        str.reverse();
        return str.toString();
    }

    // Greatest common divisor
    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}