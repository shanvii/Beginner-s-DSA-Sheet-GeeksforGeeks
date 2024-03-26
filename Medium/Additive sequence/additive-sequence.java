//{ Driver Code Starts
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution ss = new Solution();
            boolean result = ss.isAdditiveSequence(s);
            System.out.println((result == true ? 1 : 0));
        }
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public boolean isAdditiveSequence(String n) {
        // code here
        int num1 = 0;
        int size =n.length();
        for(int i=0;i < (size/2);i++){
            num1 = num1*10 + (n.charAt(i)-'0');
            int num2 = 0;
        for(int j=i+1;j<size-1;j++){
            num2 = num2*10 + (n.charAt(j)-'0');
            int first = num1,second = num2,num3=0;
            int k=j+1;
            while(k <size){
                num3 = num3*10 + (n.charAt(k)-'0');
                if(num3==first+second){
                    first = second;
                    second = num3;
                    num3 =0;
                }
                k++;
            }
            if(k==size && num3==0){
                return true;
            }
        }
        }
        return false;
    }
}
