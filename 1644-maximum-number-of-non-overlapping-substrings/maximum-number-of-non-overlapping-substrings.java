class Solution {
    public List<String> maxNumOfSubstrings(String s) {
     int n=s.length();
     //step1: find start and end of the each character
     int[] start=new int[26];
     Arrays.fill(start,-1);
     int[] end=new int[26];
      Arrays.fill(end,-1);
    for(int i=0;i<n;i++){
        int idx=s.charAt(i)-'a';
        if(start[idx]==-1){
            start[idx]=i;
        }
        end[idx]=i;
    }
    // step 2: Extend each index if possible 
    //          Mark invalid if possible
    boolean [] isValid=new boolean [26];
    Arrays.fill(isValid,true);
    for(int c=0;c<26;c++){
        if(start[c]==-1)continue;
        for(int i=start[c];i<=end[c];i++){
            if(start[s.charAt(i)-'a']<start[c]){
                isValid[c]=false;
                break;
            }
            end[c]=Math.max(end[c],end[s.charAt(i)-'a']);
        }
    }
    // step3: overlapping -> keep track of last substring s+idx
    //        smaller length substring
    List<String> list=new ArrayList<>();
    int lastTakenStart=Integer.MAX_VALUE;
    for(int i=n-1;i>=0;i--){
        int idx=s.charAt(i)-'a';
        if(!isValid[idx])continue;
        if(i==start[idx] && end[idx]<lastTakenStart){
            list.add(s.substring(i,end[idx]+1));
            lastTakenStart=i;
        }
    }
    return list;
    }
}