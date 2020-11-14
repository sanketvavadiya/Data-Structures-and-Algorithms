// { Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;
import java.lang.*;

class OddEvenSubarray
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String str[] = read.readLine().trim().split(" ");
            int arr[] = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(str[i]);
                
            System.out.println(new LongSubOfEvenOdd().maxEvenOdd(arr, n));
            
        }
    }
}   // } Driver Code Ends
//User function Template for Java

// User class to complete  
class LongSubOfEvenOdd
{
    // Complete the below function
    // arr[]: input array
    // n: size of array
    public static int maxEvenOdd(int arr[], int n)
    {
        // your code here
        int count = 1, pre_count = 0;

        for(int i=1;i<n;i++)
        {
            if((arr[i] % 2 == 0 && arr[i-1] % 2 != 0)
                    || (arr[i] % 2 != 0 && arr[i-1] % 2 == 0))
            {
                count++;
            }
            else
            {
                count = 1;
            }
            pre_count = pre_count < count ? count : pre_count;
        }
        return pre_count;
    }
}