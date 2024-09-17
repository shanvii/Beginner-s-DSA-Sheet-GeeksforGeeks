//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Solution {
    public boolean isPossible(int k, int[] arr1, int[] arr2) {
        // Your code goes here.
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int start = 0, end = arr1.length - 1;
        while(start < arr1.length) {
            if(arr1[start] + arr2[end] < k)
                return false;
            start++;
            end--;
        }
        return true;
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            String[] arr1Str = sc.nextLine().split(" ");
            String[] arr2Str = sc.nextLine().split(" ");

            int[] arr1 = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            int[] arr2 = Arrays.stream(arr2Str).mapToInt(Integer::parseInt).toArray();

            Solution solution = new Solution();
            boolean result = solution.isPossible(k, arr1, arr2);

            if (result) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
        sc.close();
    }
}
// } Driver Code Ends