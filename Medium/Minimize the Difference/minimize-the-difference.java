//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int k;
            k = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.minimizeDifference(n, k, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends

class Solution {
    // Function to minimize the difference between the maximum and minimum element in k-sized subarrays
    public static int minimizeDifference(int n, int k, int[] arr) {
        // Array to store nodes for each element
        Node[] nodes = new Node[n];
        // Initialize variables to store min and max values
        int min = Integer.MAX_VALUE, max = 0;
        
        // Populate nodes array and update min and max values
        for (int i = 0; i < n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            // Create a node for the current element with initial values
            nodes[i] = new Node(max, min, 0, Integer.MAX_VALUE);
        }
        
        // Reset min and max for next loop
        min = Integer.MAX_VALUE;
        max = 0;
        
        // Update nextLarge and nextMin values for each node
        for (int i = n - 1; i >= 0; i--) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            Node node = nodes[i];
            node.nextLarge = max;
            node.nextMin = min;
        }
        
        // Initialize pointers and result
        int i = 0, j = k - 1, ans = Integer.MAX_VALUE;
        
        // Loop through subarrays and update result
        while (j < n) {
            int a = 0, b = 0, c = Integer.MAX_VALUE, d = Integer.MAX_VALUE;
            if (i > 0) {
                a = nodes[i - 1].prevLarge;
                c = nodes[i - 1].prevMin;
            }
            if (j < n - 1) {
                b = nodes[j + 1].nextLarge;
                d = nodes[j + 1].nextMin;
            }
            max = Math.max(a, b);
            min = Math.min(c, d);
            ans = Math.min(ans, max - min);
            j++;
            i++;
        }
        return ans;
    }
}

// Node class to store previous and next large and minimum values
class Node {
    int prevLarge, nextLarge, prevMin, nextMin;
    
    // Constructor to initialize node with given values
    public Node(int pl, int pm, int nl, int nm) {
        prevLarge = pl;
        prevMin = pm;
        nextLarge = nl;
        nextMin = nm;
    }
}