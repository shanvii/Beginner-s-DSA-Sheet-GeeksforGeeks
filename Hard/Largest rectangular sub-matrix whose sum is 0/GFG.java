//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}


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
            
            int[] nm = IntArray.input(br, 2);
            
            
            int[][] a = IntMatrix.input(br, nm[0], nm[1]);
            
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.sumZeroMatrix(a);
            
            if(res.size() == 0) {
                System.out.println(-1);
                
            } else {
            
                IntMatrix.print(res);
            }        
        }
    }
}

// } Driver Code Ends




class Solution {
    static class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static ArrayList<ArrayList<Integer>> sumZeroMatrix(int[][] a) {
        int m = a.length;
        int n = a[0].length;

        int left, right, up, down;
        left = right = up = down = 0;

        for (int i = 0; i < n; i++) {
            int[] arr = new int[m];

            for (int j = i; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    arr[k] += a[k][j];
                }

                Map<Long, Integer> map = new HashMap<>();
                map.put(0L, -1);

                int l = 0, r = 0;
                long sum = 0;

                for (int k = 0; k < m; k++) {
                    sum += arr[k];

                    if (map.containsKey(sum)) {
                        if ((k - map.get(sum)) > (r - l)) {
                            l = map.get(sum) + 1;
                            r = k + 1;
                        }
                    } else {
                        map.put(sum, k);
                    }
                }

                if ((j - i + 1) * (r - l) > (right - left) * (down - up)) {
                    up = l;
                    down = r;
                    left = i;
                    right = j + 1;
                }
            }
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = up; i < down; i++) {
            ArrayList<Integer> arr = new ArrayList<>();

            for (int j = left; j < right; j++) {
                arr.add(a[i][j]);
            }

            result.add(arr);
        }

        return result;
    }
   
}

        
