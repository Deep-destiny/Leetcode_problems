class Solution {
    HashSet<Integer> set=new HashSet<>();
    public int[] findEvenNumbers(int[] digits) {
        List<Integer> ans=new ArrayList<>();
        int [] freq=new int[10];
        for(int e:digits){
            freq[e]++;
        }
        rec(freq,0,0,ans);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    private void rec(int[] freq,int idx,int num,List<Integer> ans){

        if(idx==3){
            ans.add(num);
            return;
        }
        for(int digit=0;digit<=9;digit++){
            if(idx==0 && digit==0) continue;
            if(idx==2 && digit%2!=0)continue;
            if(freq[digit]==0) continue;
            freq[digit]--;
            rec(freq,idx+1,num*10+digit,ans);
            freq[digit]++;
        }
    }
}

//         rec(digits,vis,0,0);
//         int[] arr=set.stream().mapToInt(Integer::intValue).toArray();
//         Arrays.sort(arr);
//         return arr;
//     }
//     void rec(int[] digits,boolean []vis,int idx,int num){
//         if(idx==3){
//             set.add(num);
//             return;
//         }
//         for(int i=0;i<digits.length;i++){
//             if(idx==0 && digits[i]==0) continue;
//             if(idx==2 && digits[i]%2!=0)continue;

//             if(vis[i]) continue;
//             vis[i]=true;
//             rec(digits,vis,idx+1,num*10+digits[i]);
//             vis[i]=false;
//         }
//     }
// }