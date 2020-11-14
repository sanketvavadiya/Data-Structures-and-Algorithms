//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.lang.*;
import java.io.*;

class LongestSubarrayGivenSum
{
	public static void main (String[] args)
	 {
    	 Scanner sc=new Scanner(System.in);
    	 int t=sc.nextInt();
    	 while(t-->0)
    	 {
    	        int n = sc.nextInt();
    	        int sum = sc.nextInt();
    		    int arr[] = new int[n];
    		    for(int i=0;i<n;i++){
    		        arr[i] = sc.nextInt();
    		    }
    		    System.out.println(new sumRange().subArraySum(arr, n, sum));
    		    
    		}
	}
}// } Driver Code Ends
//User function Template for Java

class sumRange
{
    static int subArraySum(int arr[], int n, int sum)
    {
        // add your code here
        HashMap <Integer, Integer> hm = new HashMap<Integer, Integer>();
        int max = 0;
        int pre_sum = 0;
        
        for(int i=0;i<n;i++){
            pre_sum += arr[i];
            if(pre_sum == sum)
                max = max < (i+1) ? (i+1) : max;
            if(hm.containsKey(pre_sum-sum)){
                max = max < (i-hm.get(pre_sum-sum)) ? (i-hm.get(pre_sum-sum)) : max;
            }
            if(!hm.containsKey(pre_sum))
                hm.put(pre_sum, i);
        }
        return max;
    }
}