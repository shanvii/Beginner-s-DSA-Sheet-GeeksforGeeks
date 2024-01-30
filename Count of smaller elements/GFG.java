//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

public class GFG {
	public static void main(String[] args)
	{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0)
        {
            int n=sc.nextInt();
            int []arr=new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
            }
            int x=sc.nextInt();
            Solution s=new Solution();
            System.out.println(s.countOfElements(arr,n,x));
        }
	}
}

// } Driver Code Ends


class Solution{
    public int countOfElements(int []arr,int n,int x)
    {
        // code here
        int count = 0;
        for(int num: arr) {
            if(num <= x)
                count++;
        }
        return count;
    }
}
