import java.util.HashMap;

class Solution {

    int M = 1000000007;

    public int numDecodings(String s) {

        HashMap<String, Integer> mp = new HashMap<>();

        mp.put("**", 15);

        mp.put("1*", 9);
        mp.put("2*", 6);
        mp.put("3*", 0);
mp.put("4*", 0);
mp.put("5*", 0);
mp.put("6*", 0);
mp.put("7*", 0);
mp.put("8*", 0);
mp.put("9*", 0);

        mp.put("*0", 2);
        mp.put("*1", 2);
        mp.put("*2", 2);
        mp.put("*3", 2);
        mp.put("*4", 2);
        mp.put("*5", 2);
        mp.put("*6", 2);

        mp.put("*7", 1);
        mp.put("*8", 1);
        mp.put("*9", 1);

        int n = s.length();

        if (s.charAt(0) == '0') {
            return 0;
        }

        if (n == 1) {
            return s.charAt(0) == '*' ? 9 : 1;
        }

        long last1 = 1;
        long last2 = 1;

        for (int i = n - 1; i >= 0; i--) {

            long count = 0;

            // Current character is 0
            if (s.charAt(i) == '0') {

                count = 0;

            } else {

                // Take one character
                if (s.charAt(i) == '*') {
                    count +=(last1 * 9) % M;
                } else {
                    count+=( last1) % M;
                }

                // Take two characters
                if (i < n - 1) {

                    String temp = s.substring(i, i + 2);

                    if (temp.charAt(0) == '*' ||
                        temp.charAt(1) == '*') {

                        count+= (last2 * mp.get(temp)) % M;

                    } else {

                        if (s.charAt(i) == '1' ||
                            (s.charAt(i) == '2' &&
                             s.charAt(i + 1) < '7')) {

                            count +=(last2) % M;
                        }
                    }
                }
            }

            // Move forward
            last2 = last1;
            last1 = count;
        }

        return (int) (last1)%M;
    }
}