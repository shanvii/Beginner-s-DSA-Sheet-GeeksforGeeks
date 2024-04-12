//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            long Arr[] = new long[N];
            String[] S = read.readLine().split(" ");
            for (int i = 0; i < N; i++) Arr[i] = Long.parseLong(S[i]);
            Solution ob = new Solution();
            System.out.println(ob.pairAndSum(N, Arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public long pairAndSum(int n, long[] arr) {
        long ans = 0;
        for (int i = 0; i < 32; i++) {
            long c = 0;
            long t = 1 << i;
            for (int j = 0; j < n; j++) {
                if ((t & arr[j]) != 0) {
                    c++; // no.of elements that have 1's on the same bit
                }
            }
            ans += (c * (c - 1) / 2) * (t); // nC2 and converting into decimal also
        }
        return ans;
    }
}

