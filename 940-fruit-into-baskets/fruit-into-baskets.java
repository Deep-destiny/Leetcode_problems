class Solution {
    public int totalFruit(int[] fruits) {
       
        int maxlen=0;
        int n=fruits.length;
        int l=0;
        int r=0;
        HashMap<Integer,Integer> freqmap=new HashMap<>();
      while(r<n){
        freqmap.put(fruits[r],freqmap.getOrDefault(fruits[r],0)+1);
        if(freqmap.size()>2){
             freqmap.put(fruits[l], freqmap.get(fruits[l]) - 1);
             if(freqmap.get(fruits[l]) ==0)freqmap.remove(fruits[l]);
             l++;
        }
        if(freqmap.size()<=2){
            maxlen=Math.max(maxlen,r-l+1);
        }
        r++;
      }
      return maxlen;
    }
}