// { Driver Code Starts
//Initial Template for Java

import java.util.Scanner;
import java.util.*;
import java.util.HashSet;

class LongestCommonSubsequence
{
    // Driver Code
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			
			for(int i=0; i<n; i++)
				a[i] = sc.nextInt();
		    
		    // Making object of GfG	
			Subseq g = new Subseq();
			
			System.out.println(g.findLongestConseqSubseq(a, n));
		
		t--;
		}
	}
}// } Driver Code Ends
//User function Template for Java

class Subseq
{   
    // Function to find Longest Consecutive Subsequence
	static int findLongestConseqSubseq(int arr[], int n)
	{
	   // add your code here
	   Arrays.sort(arr);

	   HashSet<Integer> hs = new HashSet<Integer>();
	   for(int i=0;i<n;i++)
	   	hs.add(arr[i]);

	   int temp[] = new int[hs.size()];
	   {
	   		Iterator i = hs.iterator();
	   		int j=0;
	   		while(i.hasNext()){
	   			temp[j] = (int)i.next();
	   			j++;
	   		}
	   }
	   Arrays.sort(temp);

	   int max = 0;
	   for(int i=1;i<hs.size();i++){
	   		int count = 1;
	   		while(i<hs.size() && hs.contains(temp[i]-1)){
	   			i++;
	   			count++;
	   		}
	   		if(max<count)
	   			max = count;
	   }
	   return max;
	}
}