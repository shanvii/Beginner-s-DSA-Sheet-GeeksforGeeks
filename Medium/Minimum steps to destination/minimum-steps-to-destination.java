//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int d = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            System.out.println(ob.minSteps(d));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int minSteps(int d) {
        int ans = (int) Math.ceil(Math.sqrt(2 * d + 0.25) - 0.5), y = 0;
        return ans + ((y = (ans + 2*(d%2)) % 4) == 0 ? 0 : 3 - y);
    }
}