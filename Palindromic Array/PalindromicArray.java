//{ Driver Code Starts
import java.util.*;
class PalindromicArray{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i = 0 ;i < n; i++)
				a[i]=sc.nextInt();
			GfG g = new GfG();
			System.out.println(g.palinArray(a , n));
		}
	}
}
// } Driver Code Ends


/*Complete the Function below*/
class GfG
{
	public static int palinArray(int[] a, int n)
        {
            //add code here.
            for(int ele : a) {
            if(!check(ele))
                return 0;
            }
            return 1;
        }
        
    public static boolean check(int num) {
        int copy = num;
        int rev = 0;
        
        while(copy > 0) {
            int digit = copy % 10;
            rev = rev * 10 + digit;
            copy /= 10;
        }
        
        return num == rev;
    }
}
