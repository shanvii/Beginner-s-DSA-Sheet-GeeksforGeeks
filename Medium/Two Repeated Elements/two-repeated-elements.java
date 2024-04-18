//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    for(int i=0;i<t;i++){
	        int n = Integer.parseInt(br.readLine());
	        String l = br.readLine();
    		String[] sarr = l.split(" ");
    		int[] arr = new int[sarr.length];
    		for(int i1=0;i1<arr.length;i1++){
    			arr[i1] = Integer.parseInt(sarr[i1]);
    		}
    		
            Solution obj = new Solution();
            
            int[] res = obj.twoRepeated(arr, n);
            System.out.println(res[0] + " " + res[1]);
	    }
	}
}
// } Driver Code Ends


//User function template for JAVA

class Solution {
    public int[] twoRepeated(int arr[], int n) {
        int xor = 0;
        
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        
        for (int i = 0; i < n + 2; i++) {
            xor ^= arr[i];
        }
        
        int bitChange = 0;
        
        while (((1 << bitChange) & xor) == 0) {
            bitChange++;
        }
        
        int oneCrew = 0, zeroCrew = 0;
        
        for (int i = 1; i <= n; i++) {
            if (((1 << bitChange) & i) == 0) {
                zeroCrew ^= i;
            } else {
                oneCrew ^= i;
            }
        }
        
        for (int i = 0; i < n + 2; i++) {
            if (((1 << bitChange) & arr[i]) == 0) {
                zeroCrew ^= arr[i];
            } else {
                oneCrew ^= arr[i];
            }
        }
        
        int[] res = new int[2];
        
        for (int i = n + 2 - 1; i >= 0; i--) {
            if (arr[i] == oneCrew) {
                res[1] = oneCrew;
                res[0] = zeroCrew;
                break;
            } else if (arr[i] == zeroCrew) {
                res[1] = zeroCrew;
                res[0] = oneCrew;
                break;
            }
        }
        
        return res;
    }
}