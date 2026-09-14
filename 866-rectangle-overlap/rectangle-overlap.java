class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
     /*   dimensions are x1,y1,x2,y2
        l=x2-x1
        b=y2-y1
        area =l*b
        (2-0 )*(2-0) =4
        (3-1)*(3-1)=4 good
        */
    if(  ( Math.min(rec1[2],rec2[2])-Math.max(rec1[0],rec2[0]) )> 0 && 
        (  Math.min(rec1[3],rec2[3])-Math.max(rec1[1],rec2[1]) )>0 ) return true;
        return false;
    }
}