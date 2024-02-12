//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.sequence(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long sequence(int n){
        long mod = 1000000007;
        long ans = 0L;
        int inc = 1;
        for(int i=0;i<n;i++){
            ans = ans+productOfSequence(inc,i);
            inc = inc+1+i;
        }
        return ans%mod;
        
    }
    static long productOfSequence(int start,int end){
        long mod = 1000000007;
        long product = 1L;
        for(int i=start;i<=start+end;i++){
            product = (product*i)%mod;
        }
        return product%mod;
    }
}