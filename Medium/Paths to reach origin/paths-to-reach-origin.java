//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution
{
    public static int ways(int n, int m)
    {
        // complete the function
        int dp[][] = new int[n+1][m+1];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i == 0 && j == 0){
                    dp[i][j] = 1;
                }
                else if(i == 0){
                   dp[i][j] = dp[i][j-1];
               }
               else if(j == 0){
                   dp[i][j] = dp[i-1][j];
               }
                else{
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
                }
            }
        }
        return dp[n][m];
    }
    
}


//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    int x=Integer.parseInt(elements[0]);
		    int y=Integer.parseInt(elements[1]);
		    Solution ob = new Solution();
		    System.out.println(ob.ways(x,y));
		}
	}
}
// } Driver Code Ends