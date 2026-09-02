class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        if(n % groupSize !=0) return false;
       TreeMap<Integer,Integer> mp=new TreeMap<>();
       for(int num:hand){
        mp.put(num,mp.getOrDefault(num,0)+1);
       }
        while(!mp.isEmpty()){
            int curr=mp.firstKey();
            for(int x=curr;x<curr+groupSize;x++){
                if(!mp.containsKey(x)){
                    return false;
                }
                mp.put(x,mp.get(x)-1);
                if(mp.get(x)==0) mp.remove(x);
            }
        }
        return true;
    }
}
