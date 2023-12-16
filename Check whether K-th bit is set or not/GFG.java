//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class CheckBit {
    // Function to check if Kth bit is set or not.
    static boolean checkKthBit(int n, int k) {
        // Convert the number to its binary representation
        String binary = Integer.toBinaryString(n);

        // Calculate the index from the right side (LSB) in the binary representation
        int index = binary.length() - k - 1;

        // Check if the index is valid
        if (index >= 0 && index < binary.length()) {
            // Check if the character at the calculated index is '1'
            return binary.charAt(index) == '1';
        }

        // If the index is out of range, return false
        return false;
    }
}



//{ Driver Code Starts.

class GFG
{
	static int n;
	static int k;
	
	// Driver Code
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine()); //Inputting the testcases
		
		while(t>0) //While testcases exist
		{
			
			n = Integer.parseInt(br.readLine()); //Input N
			k = Integer.parseInt(br.readLine()); // Input K
			
			CheckBit obj = new CheckBit();
			
			if(obj.checkKthBit(n, k))
				System.out.println("Yes"); //If true, print Yes
				
			else
				System.out.println("No");	// Else print No
            
            t--;
		}
	}
	
	
}
// } Driver Code Ends
