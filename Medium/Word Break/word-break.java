//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> dictionary = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            dictionary.add(p);
                        }
                    String s = sc.next();
                    Solution obj = new Solution();  
                    System.out.println(obj.wordBreak(n, s, dictionary));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int wordBreak(int N, String s, ArrayList<String> dictionary)
    {
        int n = s.length();
        int dp[] = new int[n + 1];
        dp[n] = 1;
        
        for(int i = n - 1; i >= 0; i--) 
        {
            for(int j = 0; j < N; j++) 
            {
                String word = dictionary.get(j);
                if(i + word.length() <= n && s.substring(i, i + word.length()).equals(word) && dp[i + word.length()] != 0)
                    dp[i] = 1;
            }
        }
        
        return dp[0];
    }
}