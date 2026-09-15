
class Solution {
    boolean[][] isPalindrome;

    //max non-overlapping palindromic pieces (length >= k) from s[i..j]
    public int solve(String s, int k, int i, int j, int[][] t) {
        int n = s.length();
        if (i >= n || j >= n)
            return 0;

        if (t[i][j] != -1)
            return t[i][j];

        if (isPalindrome[i][j]) { //O(1)
            int growWindow  = solve(s, k, i, j + 1, t);
            int takeIt      = 1 + solve(s, k, j + 1, j + k, t);
            int slideWindow = solve(s, k, i + 1, j + 1, t);

            return t[i][j] = Math.max(growWindow, Math.max(takeIt, slideWindow));
        }

        int slideWindow = solve(s, k, i + 1, j + 1, t);
        int growWindow  = solve(s, k, i, j + 1, t);

        return t[i][j] = Math.max(slideWindow, growWindow);
    }

    public int maxPalindromes(String s, int k) {
        int n = s.length();
        if (k == 1)
            return n; //each character can be a substring

        isPalindrome = new boolean[n + 1][n + 1];
        //Palindromic substring Blueprint
        for (int L = 1; L <= n; L++) {
            for (int i = 0; i + L <= n; i++) {
                int j = i + L - 1;

                if (i == j) {
                    isPalindrome[i][i] = true; //Single characters are palindrome
                } else if (i + 1 == j) {
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j)); //Strings of 2 Length
                } else {
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j)) && isPalindrome[i + 1][j - 1];
                }
            }
        }

        int[][] t = new int[n][n];
        for (int[] row : t) Arrays.fill(row, -1);

        return solve(s, k, 0, k - 1, t);
    }
}// class Solution {
//     int n;
//     // HashSet<String> set=new HashSet<>();
//     public int maxPalindromes(String s, int k) {
//         n=s.length();
//         int[][]dp=new int[n+1][n+1];
//         for(int []t:dp)Arrays.fill(t,-1);
//         return solve(s,k,0,k-1,dp);
//     }
//     private int solve(String s,int k,int i,int j,int[][] dp){
        
//         if(i>n-k || j>=n) return 0;
//         if(dp[i][j]!=-1) return dp[i][j];
//         if(isPalindrome(s,i,j)){
//             int take=1+solve(s,k,j+1,j+k,dp);
//             int grow=solve(s,k,i,j+1,dp);
//             int slide=solve(s,k,i+1,j+1,dp);
//             return dp[i][j]=Math.max(Math.max(grow,slide),take);
//         }
//         int grow=solve(s,k,i,j+1,dp);
//             int slide=solve(s,k,i+1,j+1,dp);
//             return dp[i][j]=Math.max(grow,slide);
//     }
//     //     ArrayList<int[]> list= new ArrayList<>();
//     //     // substring length k or more than k-> check palindrome
//     //     for(int i=0;i<=n-k;i++){
//     //         for(int j=i+k-1;j<s.length();j++){
//     //             if(Valid(s,i,j)){
//     //                 list.add(new int[]{i,j});
//     //             }
//     //         }
//     //     }
//     //     Collections.sort(list,(a,b)->a[1]-b[1]);
//     //     int cnt=0;
//     //     int last_idx=-1;
//     //     for(int[]e:list ){
//     //         int strt=e[0];
//     //         int last=e[1];
//     //         if(strt>last_idx){
//     //             cnt++;
//     //             last_idx=last;
//     //         } 
//     //     }
//     //     return cnt;
//     // }
//     private boolean isPalindrome(String str,int i,int j){
//         // check palindrome 
//         while(i<j){
//             if(str.charAt(i)!=str.charAt(j)){
//                return false;
//             }
//             i++;
//             j--;
//         }
//         return true;
//     }
// }