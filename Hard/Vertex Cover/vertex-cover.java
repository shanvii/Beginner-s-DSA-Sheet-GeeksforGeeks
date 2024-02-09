//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int m; 
            m = Integer.parseInt(br.readLine());
            
            
            int[][] edges = IntMatrix.input(br, m, 2);
            
            Solution obj = new Solution();
            int res = obj.vertexCover(n, m, edges);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends





class Solution {
    public static int vertexCover(int n, int m, int[][] edges) 
    {
        int g[][]= new int[n][n];
        for(int i= 0; i<m; i++){
            g[edges[i][0]-1][edges[i][1]-1]= 1;
            g[edges[i][1]-1][edges[i][0]-1]= 1;
        }
        
        return findCover(n, m, g);
    }
    
    public static int findCover(int n, int m, int[][] g){
        int l= 1;
        int h= n;
        while(l<h){
            int mid= (l+h)/2;
            if(checkEdges(n, mid, m, g)==false){
                l= mid+1;
            }
            else{
                h= mid;
            }
        }
        
        return l;
    }
    
    public static boolean checkEdges(int n, int k, int m, int[][] g){
        int set= (1<<k)-1;
        int limit= 1<<n;
        
        while(set<limit){
            
            boolean visited[][]= new boolean[n][n];
            int count= 0;
            
            for(int i= 1, j= 1; i<limit; i= i<<1, j++ ){
                if((set&i)!=0){
                    for(int v= 0; v<n; v++){
                        if(g[j-1][v]==1 && !visited[j-1][v]){
                            visited[j-1][v]= true;
                            visited[v][j-1]= true;
                            count++;
                        }
                    }
                }
            }
            
            if(count==m){
                return true;
            }
            
            int co= set & -set;
            int ro= set + co;
            set= (((ro^set)>>2)/co)|ro;
        }
        
        return false;
    }
}
        