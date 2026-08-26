class Solution {
    public int findContentChildren(int[] g, int[] s) {
     
    Arrays.sort(g);
    Arrays.sort(s);
    int r=0;// greedy g
    int l=0;
    while(r<g.length && l<s.length){
        if(s[l]>=g[r]) {
            l++;
            r++;
    }
    else l++;
    }
    return r;
    }
}