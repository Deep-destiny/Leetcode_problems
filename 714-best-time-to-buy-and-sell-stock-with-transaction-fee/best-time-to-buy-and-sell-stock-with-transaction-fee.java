class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;

        int t[][]=new int [n+1][2];
        
        for(int ind=n-1;ind>=0;ind--){
                for(int buy=0;buy<=1;buy++){

                    if(buy==1){
                        t[ind][buy]=
                        Math.max(-prices[ind]+t[ind+1][0],
                                0+t[ind+1][1] );
                    }
                    else{
                        t[ind][buy]=
                        Math.max(
                            prices[ind] -fee +t[ind+1][1],
                            0+t[ind+1][0]
                        );
                    }
                }
        }
return t[0][1];
    }
}