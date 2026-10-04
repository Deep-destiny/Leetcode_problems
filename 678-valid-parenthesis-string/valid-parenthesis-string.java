class Solution {
    public boolean checkValidString(String s) {
   int low_open=0;
   int high_open=0;

   for(char ch:s.toCharArray()){
    if(ch=='(') {
        low_open++;
        high_open++;
    }
    else if(ch==')'){
         low_open--;
        high_open--;
    }
    else{
        low_open--;
        high_open++;
    }
    if(high_open<0) return false;
    low_open=Math.max(low_open,0);
   }
   return low_open==0;
    }
}