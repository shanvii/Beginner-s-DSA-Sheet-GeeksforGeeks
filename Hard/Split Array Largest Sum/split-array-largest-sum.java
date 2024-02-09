//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends




class Solution {
    static int splitArray(int[] arr, int N, int K) {
        // Initialize the binary search range
        int low = Arrays.stream(arr).max().getAsInt(); // Minimum possible value for the maximum subarray sum
        int high = Arrays.stream(arr).sum(); // Maximum possible value for the maximum subarray sum

        // Perform binary search
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isPossible(arr, N, K, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    // Helper function to check if it's possible to split the array into K subarrays
    // such that the maximum subarray sum is less than or equal to the given target
    static boolean isPossible(int[] arr, int N, int K, int target) {
        int count = 0;
        int currentSum = 0;

        for (int i = 0; i < N; i++) {
            currentSum += arr[i];
            if (currentSum > target) {
                count++;
                currentSum = arr[i];
            }
        }

        count++; // Include the last subarray

        return count <= K;
    }
}