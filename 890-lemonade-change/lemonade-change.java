class Solution {
    public boolean lemonadeChange(int[] bills) {
       
        int n=bills.length;
        if(bills[0]>5){
            return false;
        }
        int fives=0;
        int tens=0;
        int twentys=0;
        for(int i=0;i<n;i++){
            int customer=bills[i];
            if(customer==5){
                fives++;
            }
            else if(customer==10){

            if(fives==0) return false;

                fives--;
                tens++;
            }
            else if(customer ==20){
                if(tens>=1 && fives>=1){
                    tens--;
                    fives--;
                    twentys++;
                }
                else if( fives>=3){
                    fives-=3;
                    twentys++;
                }
                else return false;
            }
            else return false;
        }
        return true;
    }
}
        