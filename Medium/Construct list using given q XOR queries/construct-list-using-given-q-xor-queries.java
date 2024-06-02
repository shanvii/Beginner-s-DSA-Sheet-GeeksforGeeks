//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int q;
            q = Integer.parseInt(br.readLine());

            int[][] queries = IntMatrix.input(br, q, 2);

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.constructList(q, queries);

            IntArray.print(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static ArrayList<Integer> constructList(int q, int[][] queries) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0); // Initial list containing just one element: 0
        int cumulativeXOR = 0; // To keep track of the cumulative XOR
        
        for (int i = 0; i < q; i++) {
            if (queries[i][0] == 0) {
                // Add the element to the list, adjusted by the cumulative XOR
                ans.add(queries[i][1] ^ cumulativeXOR);
            } else if (queries[i][0] == 1) {
                // Update the cumulative XOR
                cumulativeXOR ^= queries[i][1];
            }
        }
        
        // Apply the cumulative XOR to all elements before sorting
        for (int i = 0; i < ans.size(); i++) {
            ans.set(i, ans.get(i) ^ cumulativeXOR);
        }
        
        // Sort the list before returning
        Collections.sort(ans);
        return ans;
    }
}
