class Solution {
    public int reverseDegree(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int n=26;
        for(char ch='z';ch>='a';ch--){
            map.put(ch,'z'-ch +1);
        }
        int sum=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            sum+=map.getOrDefault(c,0) *(i+1);
        }
        return sum;
    }
}