class Solution {
    public String digitSum(String s, int k) {
        StringBuilder sb=new StringBuilder(s);
        while(sb.length()>k){
            StringBuilder sb2=new StringBuilder();
            int i=0;
            while(i<sb.length()){ 
            String s1=sb.substring(i,Math.min(i+k,sb.length()));
                // int num=Integer.parseInt(s1);
                int sum=0;
               
               for(int j=0;j<s1.length();j++){
                sum+=s1.charAt(j)-'0';
               }
               sb2.append(sum);
            i+=k;
        }
        sb=sb2;
    }
    return sb.toString();
    }
}