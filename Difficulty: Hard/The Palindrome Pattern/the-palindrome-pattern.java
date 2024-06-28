//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input_line[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int[][] a = new int[n][n];
            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            String ans = ob.pattern(a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String pattern(int[][] arr) {
        // Code here
        int r = arr.length;
        int c = r/2;
        
        for(int i = 0; i < r; i++) {
            boolean check = true;
            for(int j = 0; j < c; j++) {
                if(arr[i][j] != arr[i][r-j-1])
                    check = false;
            }
            if(check == true) {
                String ans = i + " R";
                return ans;
            }
        }
        
        for(int i = 0; i < r; i++) {
            boolean check = true;
            for(int j = 0; j < c; j++) {
                if(arr[j][i] != arr[r-j-1][i])
                    check = false;
            }
            if(check == true) {
                String ans = i + " C";
                return ans;
            }
        }
        
        return "-1";
    }
}
