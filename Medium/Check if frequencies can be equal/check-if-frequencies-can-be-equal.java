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
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            
            Solution ob = new Solution();
            if(ob.sameFreq(a)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    boolean sameFreq(String s) {
        
        Map<Character,Integer>mp=new HashMap<>();
        int maxFreq=0;
        for(int i=0;i<s.length();i++)
        {
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
            maxFreq=Math.max(maxFreq,mp.get(s.charAt(i)));
        }
        int count=0;
        for(int i:mp.values())
        {
            if(maxFreq-i>1)
                return false;
            if(maxFreq==i)
                count++;
        }
        
        if(count>1 && count<mp.size())
            return false;
        return true;
    }
}