class Solution {
    int n;
    int m;
    public boolean isMatch(String s, String p) {
        n=s.length();
        m=p.length();
        Boolean [][] dp=new Boolean [n+1][m+1];
        return rec(0,0,s,p,dp);
    }
    private boolean rec(int i,int j,String s,String p,Boolean [][]dp){
        if(j == m) return i==n;
        if(dp[i][j]!=null) return dp[i][j];
        boolean match=i<n && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');
      if(j+1< m && p.charAt(j+1)=='*') return rec(i,j+2,s,p,dp) || ( match&& rec(i+1,j,s,p,dp));

      return dp[i][j]=match && rec(i+1,j+1,s,p,dp);

        }
    }