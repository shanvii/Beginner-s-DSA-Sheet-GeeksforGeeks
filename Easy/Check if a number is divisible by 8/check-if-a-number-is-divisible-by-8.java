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
            String S=read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.DivisibleByEight(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int DivisibleByEight(String s) {
        int n = s.length(), num = 0;
        for (int i = n < 4 ? 0 : n - 3; i < n; i++)
            num = (num * 10) + (s.charAt(i) - '0');
    
        return num % 8 == 0 ? 1 : -1;
    }
}