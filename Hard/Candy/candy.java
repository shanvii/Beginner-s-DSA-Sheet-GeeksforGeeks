//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.minCandy(n, a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    static int minCandy(int N, int ratings[]) {
        // Initialize the candies arrays
        int[] leftToRight = new int[N];
        int[] rightToLeft = new int[N];
        
        // Initialize candies for each child to 1
        Arrays.fill(leftToRight, 1);
        Arrays.fill(rightToLeft, 1);

        // Traverse from left to right and assign candies based on ratings
        for (int i = 1; i < N; i++) {
            if (ratings[i] > ratings[i - 1]) {
                leftToRight[i] = leftToRight[i - 1] + 1;
            }
        }

        // Traverse from right to left and assign candies based on ratings
        for (int i = N - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                rightToLeft[i] = rightToLeft[i + 1] + 1;
            }
        }

        // Calculate the total minimum candies required
        int totalCandies = 0;
        for (int i = 0; i < N; i++) {
            totalCandies += Math.max(leftToRight[i], rightToLeft[i]);
        }

        return totalCandies;
    }
}