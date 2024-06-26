//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.findCoverage(matrix);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findCoverage(int[][] matrix) {
        // code here
        int rows = matrix.length;
        int columns = matrix[0].length;
        
        int count = 0;
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                
                if(matrix[i][j] == 0) {
                    if(i-1 >=0 && matrix[i-1][j] == 1) count++;
                    if(j-1 >=0 && matrix[i][j-1] == 1) count++;
                    if(i+1 < rows && matrix[i+1][j] == 1) count++;
                    if(j+1 < columns && matrix[i][j+1] == 1) count++;
                }
            }
        }
        return count;
    }
}