//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            int  k = Integer.parseInt(read.readLine());
            int  n = Integer.parseInt(read.readLine());
            int arr[][] = new int[n][n];
            String input_line1[] = read.readLine().trim().split("\\s+");
            int c = 0;
            for(int i=0;i<n;i++){
                for(int j = 0;j<n;j++){
                    arr[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            Solution obj = new Solution();
            System.out.println(obj.numberOfPath(n, k, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
   
    long numberOfPath(int n, int k, int [][]arr) {
        return find(n,k,0,0,arr);
    }
    long find(int n,int k,int i,int j,int [][]arr){
        if(i>=n || j>=n || k<0)  return 0;
        k=k-arr[i][j];
        if(i==n-1 && j==n-1){
            if(k==0)return 1;
            return 0;
        }
        return  find(n,k,i,j+1,arr)+find(n,k,i+1,j,arr);
    }
    
}