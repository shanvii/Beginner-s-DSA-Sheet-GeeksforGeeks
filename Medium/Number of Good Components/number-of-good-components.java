//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int e;
            e = Integer.parseInt(br.readLine());

            int v;
            v = Integer.parseInt(br.readLine());

            int[][] edges = IntMatrix.input(br, e, 2);

            Solution obj = new Solution();
            int res = obj.findNumberOfGoodComponent(e, v, edges);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findNumberOfGoodComponent(int e, int v, int[][] edges) {
        // code here
        boolean vis[] = new boolean[v+1];
        Arrays.fill(vis,false);
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=v;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        int res=0;
        for(int i=0;i<=v;i++){
            if(graph.get(i).size()==0){
                res++;
                vis[i]=true;
                continue;
            }
            HashMap<Integer,Integer> map = new HashMap<>();
            if(!vis[i] ){
                int z=dfs(graph,i,vis,map);
                if(isvalid(map,z))
                    res++;
            } 
            
        }
        return res-1;
    }
    
    static int dfs(ArrayList<ArrayList<Integer>> graph,int cur,boolean[] vis,HashMap<Integer,Integer> map){
        vis[cur]=true;
        ArrayList<Integer> temp = graph.get(cur);
        int z=1;
        for(int i=0;i<temp.size();i++){
            int a=temp.get(i);
            map.put(a,map.getOrDefault(a,0)+1);
        }
        for(int i=0;i<temp.size();i++){
            if(!vis[temp.get(i)]){
                z+=dfs(graph,temp.get(i),vis,map);
            }
        }
        return z;
    }
    
    static boolean isvalid(HashMap<Integer,Integer> map,int z){
        
        int a=z-1;
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            if(a==0){
                a=e.getValue();
            }else{
                if(a!=e.getValue()) return false;
            }
        }
        return true;
    }
}
