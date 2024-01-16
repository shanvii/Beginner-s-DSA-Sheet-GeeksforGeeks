//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
    		int[] res = new Sol().count (s);
    		
    		for (int i = 0; i < 4; i++)
    		    System.out.println (res[i]);
        }
        
    }
}
// Contributed By: Pranay Bansal

// } Driver Code Ends


//User function Template for Java

class Sol
{
    int[] count (String s)
    {
        // your code here   
        int[] arr = new int[4];
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar >= 'A' && currentChar <= 'Z')
                arr[0]++;
            else if (currentChar >= 'a' && currentChar <= 'z')
                arr[1]++;
            else if (currentChar >= '0' && currentChar <= '9')
                arr[2]++;
            else
                arr[3]++;
        }
        return arr;
    }
}
