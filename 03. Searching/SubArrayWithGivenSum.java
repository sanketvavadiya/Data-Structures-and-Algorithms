import java.util.*;
import java.lang.*;
import java.io.*;

class SubArrayWithGivenSum{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();

            int[] m = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }
            
            Subarray obj = new Subarray();
            obj.subarraySum(n, s, m);
            System.out.println();
        }
    }

}// } Driver Code Ends
class Subarray{
    
    // Function to find subarray with given sum
    static void subarraySum(int n, int s, int[] arr) {
        
        // Your code here
        if(arr[0]==s){
            System.out.print(1 + " " + 1);
            return;
        }
            
        int start=0, end=0, sum=0;
        while(end<=n){
            if(sum<s){
                sum += arr[end++];
            }
            else if(sum>s){
                sum-=arr[start++];
            }
            if(sum==s){
                System.out.print((start+1) + " " + (end));
                return;
            }
        }
        System.out.print(-1);        
    }
}

