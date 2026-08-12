class Solution {
    public int minimumChairs(String s) {
           int c=0,d=0;
        for(char ch:s.toCharArray()){
            if(ch=='E') {
                c++;
                d=Math.max(d,c);
            }
            else{
                if(c>0){
                    c--;
                }
                else{
                    d++;
                }
            }
        }
        return d;
    }
}
    //     int distinct_chairs=0;
    //     int curr_chairs=0;
    //     for(char ch:s.toCharArray()){
    //         if(ch=='E'){
    //             curr_chairs++;
    //             distinct_chairs=Math.max(curr_chairs,distinct_chairs);
    //         }
    //         else{
    //             if(curr_chairs>0){
    //                 curr_chairs--;
    //             }
    //             else{
    //                 distinct_chairs++;
    //             }
    //         }
    //     }
    //     return distinct_chairs;
    // }
