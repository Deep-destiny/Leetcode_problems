class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        Stack<Integer> st=new Stack<>();
   for(int i=0;i<n;i++){
    if(asteroids[i]>0){ st.push(asteroids[i]);
    continue;
    }
    while(!st.isEmpty() && st.peek()>0 && st.peek()<Math.abs(asteroids[i]) ){
            st.pop();
    }
    if(!st.isEmpty() && st.peek()==Math.abs(asteroids[i])){
        st.pop();
    }
    else if(st.isEmpty() || st.peek()<0) st.push(asteroids[i]);
   }
    int [] res= new int[st.size()];
    for(int i=0;i<st.size();i++){
        res[i]=st.get(i);
    }
    return res;
}
}