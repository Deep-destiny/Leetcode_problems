class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
      // 
      /*
      start and end of another interval --> neew interval
      merge the interval that re overlapping in any manner
      check every interval [a,b] for(int i=a;i<=b;i++){
      if(new interval [i] is <=a && <=b  it is included and if( newinterval [1]>=b) then insert a new interval [a ,new interval[1]])
      */
    // 
        List<int[]> ans=new ArrayList<>();
        int i=0;
        int n=intervals.length;

            while(i< n && intervals[i][1]<newInterval[0]){
                ans.add(intervals[i]);
                i++;
            }

            while(i<n && intervals[i][0]<=newInterval[1]){
                newInterval[0]=Math.min(intervals[i][0],newInterval[0]);
                newInterval[1]=Math.max(intervals[i][1],newInterval[1]);
                i++;
            }
            ans.add(newInterval);
            while(i<n){
                ans.add(intervals[i]);
                i++;
            }
            return ans.toArray(new int[ans.size()][]);
        }
}