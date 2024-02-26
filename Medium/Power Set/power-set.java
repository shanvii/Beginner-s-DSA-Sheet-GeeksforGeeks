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
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
      List<String> a=new ArrayList<>();
      solve(s,"",a);
      Collections.sort(a);
 
      return a;
    }
    void solve(String s,String ans,List<String> a){
        if(s.length()==0)
        {
            if(!ans.equals(""))
            a.add(ans);
            return;
        }
        char ch=s.charAt(0);
        String r=s.substring(1);
        solve(r,ans,a);
        solve(r,ans+ch,a);
        return ;
    }
}