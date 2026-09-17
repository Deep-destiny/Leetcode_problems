class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] pref = new int[n + 1];

        // Prefix sum
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + arr[i];
        }

        int INF = 1000000000;
        int[] best = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            best[i] = INF;
        }

        // best[i] = shortest valid subarray ending before i
        for (int i = 0; i < n; i++) {
            int end = binarySearch(pref, pref[i] + target);

            if (end <= n && pref[end] == pref[i] + target) {
                best[end] = Math.min(best[end], end - i);
            }
        }

        // Carry forward the shortest length
        for (int i = 1; i <= n; i++) {
            best[i] = Math.min(best[i], best[i - 1]);
        }

        int ans = INF;

        // Find second subarray starting at i
        for (int i = 0; i < n; i++) {
            int end = binarySearch(pref, pref[i] + target);

            if (end <= n && pref[end] == pref[i] + target) {
                if (best[i] != INF) {
                    ans = Math.min(ans, best[i] + end - i);
                }
            }
        }

        return ans == INF ? -1 : ans;
    }

    int binarySearch(int[] pref, int target) {
        int l = 0, r = pref.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (pref[mid] == target) {
                return mid;
            } else if (pref[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return l; // insertion point
    }
}