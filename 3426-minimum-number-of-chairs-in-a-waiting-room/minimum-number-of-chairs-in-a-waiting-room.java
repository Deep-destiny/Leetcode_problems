class Solution {
    public int minimumChairs(String s) {
        int distinct_chairs=0;
        int curr_chairs=0;
        for(char ch:s.toCharArray()){
            if(ch=='E'){
                curr_chairs++;
                distinct_chairs=Math.max(curr_chairs,distinct_chairs);
            }
            else{
                if(curr_chairs>0){
                    curr_chairs--;
                }
                else{
                    distinct_chairs++;
                }
            }
        }
        return distinct_chairs;
    }
}