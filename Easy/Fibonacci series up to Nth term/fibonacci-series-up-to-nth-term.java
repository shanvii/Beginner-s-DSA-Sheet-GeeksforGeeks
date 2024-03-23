//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int ans[] = obj.Series(n);
            for (int i : ans) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {

    int[] Series(int n) {
        // code here
        
        int a=0;
        int b=1;
        int [] arr=new int[n+1];
        arr[0]=0;
        if(n==0){
            return arr;
        }
        
        arr[1]=1;
        
        if(n==1){
            return arr;
        }
        for(int i=2;i<=n;i++){
            int c=(a+b)%1000000007;
            arr[i]=c;
            a=b;
            b=c;
        }
        
        return arr;
    }
}