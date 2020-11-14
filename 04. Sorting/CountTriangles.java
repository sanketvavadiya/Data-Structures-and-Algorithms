// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class CountTriangles
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i = 0; i < n; i++)
              arr[i] = sc.nextInt();
             System.out.println(new Count_possible_triangle().findNumberOfTriangles(arr, n));
        }
    }
}// } Driver Code Ends
//User function Template for Java

class Count_possible_triangle
{
    // Function to find number of triangles that can be formed
    // arr[]: input array
    // n: size of array
    static long findNumberOfTriangles(int arr[], int n)
    {
        // add your code here
        Arrays.sort(arr);

        long count = 0;
        for(int i=0;i<n-2;i++)
        {
            int k = i+2;
            for(int j=i+1;j<n-1;j++)
            {
                int twoSide = arr[i] + arr[j];
                while(k<n && arr[k] < twoSide)
                    k++;
                count += k - j -1;
            }
        }
        return count;
    }
}