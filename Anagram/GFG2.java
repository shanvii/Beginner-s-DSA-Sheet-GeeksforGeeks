//{ Driver Code Starts
import java.util.*;
import java.util.stream.*; 
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    String str = br.readLine();
		    String s1 = str.split(" ")[0];
		    String s2 = str.split(" ")[1];
		    
		    Solution obj = new Solution();
		    
		    if(obj.isAnagram(s1,s2))
		    {
		        System.out.println("YES");
		    }
		    else
		    {
		         System.out.println("NO");
		    }
		    
		    
		    
		}
	}
}
// } Driver Code Ends


class Solution
{    
    //Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String a,String b)
    {
        
        // Your code here
        // Check if lengths are different
        if (a.length() != b.length())
            return false;
        
        // Create an array to store character counts
        int[] charCount = new int[26]; // Assuming lowercase English letters
        
        // Increment count for characters in string 'a'
        for (int i = 0; i < a.length(); i++) {
            charCount[a.charAt(i) - 'a']++;
        }
        
        // Decrement count for characters in string 'b'
        for (int i = 0; i < b.length(); i++) {
            charCount[b.charAt(i) - 'a']--;
        }
        
        // Check if all counts are zero
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }
        
        return true;
    }
}
