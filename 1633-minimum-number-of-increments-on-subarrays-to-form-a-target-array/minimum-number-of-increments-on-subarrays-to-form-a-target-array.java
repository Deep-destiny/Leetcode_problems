class Solution {
    public int minNumberOperations(int[] target) {
        int prev=0;
        int n=target.length;
        int op=0;
        int i=0;
        while(i<n){
            int curr=target[i];
            if(prev<curr){
                op+=Math.abs(curr-prev);
            }
            prev=curr;
            i++;
        }
        return op;
    }
}