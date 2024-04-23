//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.firstElement(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static int firstElement(int n) {
        int a=1;
        int b=1;
        int mod=1000000007;
        
        if(n==0 || n==1) return 1;
        
        if(n==2)return 2;
        
        for(int i=2;i<n;i++){
                int temp=a;
                a=(a+b)%mod;
                b=temp;
        }
        return a;
       
    }
}