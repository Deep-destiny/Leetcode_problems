class Solution {
    public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
    for(int e:stones){
        pq.offer(e);
    }
    while(pq.size()>=2){
        int p=pq.poll();
        int q=pq.poll();
        int e=Math.abs(p-q);
        if(e>0) pq.offer(e);
    }
    return (pq.size()==0)?0:pq.poll();
    }
}