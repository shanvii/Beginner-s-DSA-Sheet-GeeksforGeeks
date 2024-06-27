//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.isDisarium(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int isDisarium(int num) {
        // code here
        int sum = 0, count = 0, copy = num;

        while(copy > 0) {
            count++;
            copy/=10;
        }

        copy = num;

        while(copy > 0) {
            sum += Math.pow(copy%10, count--);
            copy/=10;
        }

        if(sum == num)
            return 1;
        return 0;
    }
};