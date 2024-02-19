//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minValue(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution{
    static int minValue(String s, int k){
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int arr[] = new int[26];
        
        for(char c : s.toCharArray()){
            arr[c - 'a']++;
        }
        
        for(int it : arr){
            if(it > 0) {
                pq.offer(it);
            }
        }
        
        while(k > 0){
            int num = pq.poll();
            num -= 1;
            pq.offer(num);
            k--;
        }
        
        int ans = 0;
        for(int n : pq){
            ans += (n*n);
        }
        
        return ans;
    }
}