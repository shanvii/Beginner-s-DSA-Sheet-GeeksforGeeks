//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String str1 = sc.next();
            String str2 = sc.next();

            Solution obj = new Solution();
            String ans = obj.betterString(str1, str2);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    public static String betterString(String str1, String str2) {
        // Code here
        
        int count1 = countDistinctSubsequence(str1);
        int count2 = countDistinctSubsequence(str2);
        
       if(count1 < count2)
            return str2;
        else
            return str1;
    }
    
    public static int countDistinctSubsequence(String str) {
        int[] lastOccurrence = new int[256];
        Arrays.fill(lastOccurrence, -1);
        
        int mod = 1000000007;
        int n = str.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        
        for(int i =1; i<=n; i++) {
            dp[i] = (2*dp[i-1]) % mod;
            
            if(lastOccurrence[str.charAt(i-1)] != -1)
                dp[i] = (dp[i] - dp[lastOccurrence[str.charAt(i-1)] - 1] + mod) % mod;
                
            lastOccurrence[str.charAt(i-1)] = i;
        }
        return dp[n];
    }
}