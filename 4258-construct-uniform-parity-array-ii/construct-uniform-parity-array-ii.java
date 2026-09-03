class Solution {
    public boolean uniformArray(int[] nums1) {
        int n=nums1.length;
        int even=0;
        int odd=0;
        for(int i=0;i<n;i++){
            if(nums1[i]%2==0) even++;
            else odd++;
        }
        if(even ==0 || odd==0) return true;

    int minOdd=Integer.MAX_VALUE;
    for(int num:nums1){
        if(num%2!=0){
            minOdd=Math.min(minOdd,num);
        }
    }
    
        boolean possibleOdd=true;
        for(int num:nums1){
            if(num%2==0 && num<=minOdd){
                possibleOdd=false;
                break;
            }
        }
    return possibleOdd;
    }
    }

//             int[]even=new int[n];
//             int []odd=new int[n];
//             int even_zero=0;
//             int odd_zero=0;
//         for(int i=0;i<n;i++){
//             if(nums1[i]%2==0){
            
//             even[i]=nums1[i];
//             odd[i]=get(i,nums1,true);
//         }
//         else{
//             odd[i]=nums1[i];
//             even[i]=get(i,nums1,false);
//         }
//     }
//     for(int i=0;i<n;i++){
//          if(even[i]==0) even_zero++;
//          if(odd[i]==0) odd_zero++;
//     }
//     if(even_zero==0 || odd_zero==0 ) return true;
   
//     return false;
// }
//        private int get(int idx,int[] nums1,boolean eve){
//             int ans=0;
            
//                 for(int j=0;j<nums1.length;j++){
//                     if(idx!=j && nums1[idx]>nums1[j]){
//                          int num=nums1[idx]-nums1[j];
//                         if(eve && num%2!=0){
//                             ans=num;
//                             break;
//                         }
//                     if(!eve && num%2==0){
//                         ans=num;
//                         break;
//                     }
//                 }
//             }
//             return ans;
//                 }


//             }
     


