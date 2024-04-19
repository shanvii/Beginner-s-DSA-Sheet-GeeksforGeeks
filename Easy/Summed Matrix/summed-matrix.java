//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            long n = Long.parseLong(S[0]);
            long q = Long.parseLong(S[1]);

            Solution ob = new Solution();
            System.out.println(ob.sumMatrix(n,q));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution {
    static long sumMatrix(long n, long q) {
        long count = 0;

        // Check if q falls within the range of possible values in the matrix
        if (q >= 2 && q <= 2 * n) {
            // Calculate the range of rows where q may exist
            // The minimum row number is q - 1 and the maximum row number is n
            long minRow = Math.max(1, q - n);
            long maxRow = Math.min(q - 1, n);

            // Count the number of columns for each row where q may exist
            count = maxRow - minRow + 1;
        }

        return count;
    }
};