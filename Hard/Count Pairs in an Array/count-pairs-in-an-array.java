//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();  
            System.out.println(obj.countPairs(a, n));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {  
    static int countPairs(int arr[], int n) 
    {
         // Your code goes here
         for(int i=0;i<n;i++)arr[i]*=i;
        return mergeSort(arr,0, n-1);
    }
    static int mergeSort(int[]arr, int low, int high){
        int count = 0;
        if(low<high){
            int mid = (low+high)/2;
            count += mergeSort(arr,low,mid);
            count += mergeSort(arr, mid+1,high);
            count += merge(arr,low,mid,high);
        }
        return count;
    }
    
    static int merge(int[]arr, int low, int mid, int high){
        int count = 0;
        int j = mid+1;
        
        /*  finding pair */
        for(int i=low;i<=mid;i++){
         while(j<=high&&arr[i]>arr[j])j++;
          count+=(j-(mid+1));
        }
      
        int n = mid-low+1;
        int m = high-mid;
        int[]left = new int[n];
        int[]right = new int[m];
        for(int i=0;i<n;i++){
            left[i] = arr[low+i];
        }
        for(int i=0;i<m;i++){
            right[i] = arr[mid+i+1];
        }
        int i=0;
        j = 0;
        int k = low;
        while(i<n && j<m){
            if(left[i]<=right[j]){
                arr[k++] = left[i++];
            }else{
                arr[k++] = right[j++];
            }
        }
        while(i<n)arr[k++] = left[i++];
        while(j<m)arr[k++] = right[j++];
        return count;
    }
}