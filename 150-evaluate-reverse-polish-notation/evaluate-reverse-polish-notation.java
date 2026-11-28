class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        for(String s:tokens){
            if(s.equals("*") ||s.equals("/") || s.equals("+") || s.equals("-") ){
                int num2=st.pop();
                
                int num1=st.pop();
               
                int res=switch(s){
                     case "*" -> num1 * num2;
                            case "/" -> {
                                if (num2 == 0) throw new ArithmeticException("Cannot divide by zero");
                                yield num1 / num2;
                            }
                            case "+" -> num1 + num2;
                            case "-" -> num1 - num2;
                            default -> 0;
                        };
                        st.push(res);
            }
            else {
                int num=Integer.parseInt(s);
                st.push(num);
            }
        }
        return st.peek();
    }
}