//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Solution ob = new Solution();

        int T = sc.nextInt();

        while (T != 0) {
            long n = sc.nextLong();
            if (ob.fascinating(n))
                System.out.println("Fascinating");
            else
                System.out.println("Not Fascinating");
            T--;
        }
    }
}
// } Driver Code Ends


class Solution {
    boolean fascinating(long n) {
        // code here
        String concatenatedString = n + "" + (n * 2) + (n * 3);

        for (char digit = '1'; digit <= '9'; digit++) {
            int count = 0;
            for (int i = 0; i < concatenatedString.length(); i++) {
                if (concatenatedString.charAt(i) == digit) {
                    count++;
                }
            }
            if (count != 1) {
                return false;
            }
        }

        return true;
    }
}
