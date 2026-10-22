class Solution {
    public boolean isPalindrome(String s) {
       String s_new=s.toLowerCase();
        // uppercase-> lowercase remove all characters 
        String[] words=s_new.split(" ");
     
          StringBuilder ns=new StringBuilder();
        for(String s2:words){
            for(char ch:s2.toCharArray()){
                if(Character.isLetterOrDigit(ch)) ns.append(ch);
            }
        }
            return solve(ns,0,ns.length()-1);
    }
    private boolean solve(StringBuilder ns,int l,int h){
        if(l==h) return true;
        while(l<=h){
            if(ns.charAt(l)!=ns.charAt(h)) return false;
                l++;
                h--;
            }
            return true;
        }
}