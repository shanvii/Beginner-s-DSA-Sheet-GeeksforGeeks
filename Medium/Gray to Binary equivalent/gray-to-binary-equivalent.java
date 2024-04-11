//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    
    // function to convert a given Gray equivalent n to Binary equivalent.
    public static int grayToBinary(int n) {
        int[] bin = new int[32];
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                bin[i] = 1;
            }
        }
        int ans = bin[31];
        for (int i = 30; i >= 0; i--) {
            bin[i] = bin[i+1] ^ bin[i];
            ans = ans * 2 + bin[i];
        }
        return ans;
    }
       
}


//{ Driver Code Starts.

class GFG {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();//testcases
		while(t-->0){
		    int n = sc.nextInt();//initializing n
		    
		    Solution obj = new Solution();
		    
		    //calling grayToBinary() function
		    System.out.println(obj.grayToBinary(n));
		}
	}
}

// } Driver Code Ends