//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java

class Solution{
    static int fib(int N){
        //code here
        if (N <= 1) return N;

        int a = 0, b = 1, temp = 0;

        for (int i = 2; i <= N; i++) {
            temp = a + b;
            a = b;
            b = temp%10;
        }

        return temp%10;
    }
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
           
            Solution ob = new Solution();
            System.out.println(ob.fib(N));
        }
    }
}
// } Driver Code Ends