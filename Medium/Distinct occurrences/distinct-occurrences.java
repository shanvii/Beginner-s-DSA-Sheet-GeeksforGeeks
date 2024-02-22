//{ Driver Code Starts
import java.util.*;

class Distinct_Occurrences
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String line = sc.nextLine();
			String S = line.split(" ")[0];
			String T = line.split(" ")[1];
			
			Solution ob = new Solution();
			System.out.println(ob.subsequenceCount(S,T));
			t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete this method*/

class Solution
{
    int subsequenceCount(String s, String t)
    {
        int n = s.length();
        int m = t.length();
        int mod = (int)1e9+7;
        int[] p = new int[m+1];
        int[] c = new int[m+1];
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            c[0] = 1;
            for (int j = 1; j <= m; j++) {
                int np = p[j] % mod;
                int pi = 0;
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    pi = p[j-1] % mod;
                }
                c[j] = (np + pi) % mod;
            }
            p = c.clone();
        }
        return p[m];
    }
}