//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
class Solution {
    static long fibSum(long N) {
        // code here
        if(N <= 1)  return N;
        int mod = 1000000007;
        int a = 0, b = 1;
        long sum = 1;
        for(int i = 2; i <= N; i++) {
            int nextFib =(a + b)%mod;
            sum += nextFib;
            a = b;
            b = nextFib;
        }
        return sum % mod;
    }
}

//{ Driver Code Starts.
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.fibSum(N));
        }
    }
}
// } Driver Code Ends