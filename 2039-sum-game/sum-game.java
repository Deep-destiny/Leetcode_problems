class Solution {
    public boolean sumGame(String num) {

     int n=num.length();
     int leftknownsum=0;
     int  rightknownsum=0;

     int left_quesmark=0;
     int right_quesmark=0;


    for(int i=0;i<n;i++){
        if(num.charAt(i)=='?')
        {
                if(i< n/2) left_quesmark++;
                else right_quesmark++;
        }
        else{
            if(i<n/2){
                leftknownsum+=num.charAt(i)-'0';
            }
            else{
                rightknownsum+=num.charAt(i)-'0';

            }
        }
    }
    int total_quesmark= left_quesmark + right_quesmark;
    if(total_quesmark%2==1) return true;
    int l=2*leftknownsum + 9 * left_quesmark;
    int r=2*rightknownsum+9* right_quesmark;
    if(l==r) return false;
    return true;
    }
}