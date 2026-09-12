
class Solution {
    int n;
    int[][] intervals;
    int[] nextIdx;

    static class Node {
        long score = -1;
        List<Integer> idxs = new ArrayList<>();
    }

    Node[][] t;

    int findNext(int r) {
        int lo = 0, hi = n - 1;
        int result = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (intervals[mid][0] > r) {
                result = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return result;
    }

    boolean isLexSmaller(List<Integer> a, List<Integer> b) {
        int len = Math.min(a.size(), b.size());
        for (int i = 0; i < len; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }
        return a.size() < b.size();
    }

    Node solve(int i, int k) {
        if (k == 0 || i >= n)
            return new Node();

        if (t[i][k].score != -1)
            return t[i][k];

        int weight = intervals[i][2];
        int idx    = intervals[i][3];
        int j      = nextIdx[i];

        //skip interval i
        Node skip = solve(i + 1, k);

        //take interval i
        Node temp = solve(j, k - 1);
        Node take = new Node();
        take.score = temp.score + weight;
        take.idxs  = new ArrayList<>(temp.idxs);
        take.idxs.add(idx);
        Collections.sort(take.idxs);

        Node result;
        if (skip.score > take.score) {
            result = skip;
        } else if (skip.score < take.score) {
            result = take;
        } else {
            result = isLexSmaller(skip.idxs, take.idxs) ? skip : take;
        }

        t[i][k] = result;
        return result;
    }

    public int[] maximumWeight(List<List<Integer>> intervalsList) {
        n = intervalsList.size();

        intervals = new int[n][4];
        for (int i = 0; i < n; i++) {
            intervals[i][0] = intervalsList.get(i).get(0);
            intervals[i][1] = intervalsList.get(i).get(1);
            intervals[i][2] = intervalsList.get(i).get(2);
            intervals[i][3] = i;
        }

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            if (a[2] != b[2]) return a[2] - b[2];
            return a[3] - b[3];
        });

        nextIdx = new int[n];
        for (int i = 0; i < n; i++) {
            int r = intervals[i][1];
            nextIdx[i] = findNext(r);
        }

        final int K = 4;
        t = new Node[n + 1][K + 1];
        for (int i = 0; i <= n; i++)
            for (int k = 0; k <= K; k++)
                t[i][k] = new Node();

        Node res = solve(0, K);
        int[] ans = new int[res.idxs.size()];
        for (int i = 0; i < ans.length; i++)
            ans[i] = res.idxs.get(i);
        return ans;
    }
}

// class Solution {

//     public int[] maximumWeight(List<List<Integer>> intervals) {
//         int n=intervals.size();
//         int [][]arr=new int[n][4];
        
//         for(int i=0;i<n;i++){
//             List<Integer> e=intervals.get(i);
//             arr[i][0]=e.get(0);
//             arr[i][1]=e.get(1);
//             arr[i][2]=e.get(2);
//             arr[i][3]=i;
//         }
//         Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
//         long[][]dp=new long[n+1][5];
//         for(long[]r:dp)Arrays.fill(r,-1);
//         List<Integer> ans=new ArrayList<>();
//         rec(arr,0,0,dp);
//         int i=0;
//         int limit=0;
//         while(i<n && limit<4){
//                long skip=rec(arr,i+1,limit,dp);
//                int next=findNext(arr,i);

//         long take=arr[i][2]+rec(arr,next,limit+1,dp);
    
//     if(take>=skip){
//         ans.add(arr[i][3]);
//         i=next;
//         limit++;
//     }
//     else{
//         i++;
//     }
//         }
//         Collections.sort(ans);
//         int[] res=new int[ans.size()];
//         for(int j=0;j<ans.size();j++) res[j]=ans.get(j);
//         return res;
//     }
//     private long rec(int[][]arr, int i,int limit,long[][]dp){
//         if(limit==4 || i==arr.length) return 0;
//         if(dp[i][limit]!=-1) return dp[i][limit];
//         long skip=rec(arr,i+1,limit,dp);
//         int next=findNext(arr,i);
//         long take=arr[i][2]+rec(arr,i+1,limit+1,dp);
//         return dp[i][limit]= Math.max(skip,take);
//     }
// private int findNext(int [][]arr,int i){
//     int l=i+1;
//     int h=arr.length;
//     while(l<h){
//         int mid=l+(h-l)/2;
//         if(arr[mid][0]>arr[i][1]){
//             h=mid;
//         }
//         else l=mid+1;
//     }
//     return l;
// }
// }