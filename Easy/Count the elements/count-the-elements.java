//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		// looping through all testcases
		while(testcases-- > 0){
		    int n=Integer.parseInt(br.readLine());
		    String line1 = br.readLine();
		    String line2 = br.readLine();
		    String[] a1 = line1.trim().split("\\s+");
		    String[] b1 = line2.trim().split("\\s+");
		    int a[]=new int[n];
		    int b[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=Integer.parseInt(a1[i]);
		        b[i]=Integer.parseInt(b1[i]);
		    }
		    int q = Integer.parseInt(br.readLine());
		    int query[]=new int[q];
		    for(int i=0;i<q;i++)
		    {
		        query[i]=Integer.parseInt(br.readLine());
		    }
		    Solution ob=new Solution();
		    int ans[]=ob.countElements(a,b,n,query,q);
		    for(int i=0;i<q;i++)
		    System.out.println(ans[i]);
		    
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int[] countElements(int a[], int b[], int n, int query[], int q)
    {
        ArrayList <Integer> ans= new ArrayList<>();
        

        for(int i=0;i<query.length;i++){
            int index = query[i];                       //    Get Index
            int element = a[index];               //   Get Element 
            int count = 0;                              //   Counter
            for(int j=0;j<n;j++){                       // Count Element
                if(b[j] <= element){
                    count++;
                }
            }
            ans.add(count);             // Store count in arrayList
        }

        int arr[] = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            arr[i] = ans.get(i);
        }
        return arr;
    }
}