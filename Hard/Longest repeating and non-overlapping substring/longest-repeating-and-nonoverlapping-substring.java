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
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestSubstring(S, N));
        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution {
    static String longestSubstring(String S, int N) {
        // code here
        int max=0;
        String ans="-1";
        int i=0, j=0;
        while(i<N && j<N){
            String subString= S.substring(i, j+1);
            if(S.indexOf(subString, j+1)!=-1){
                int len= subString.length();
                if(len>max){
                    ans=subString;
                }
            }
            else{
                i++;
            }
            j++;
        }
        return ans;
    }
}