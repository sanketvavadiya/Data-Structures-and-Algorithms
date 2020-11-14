// { Driver Code Starts
//Initial Template for Java


// Java implementation of the approach 
import java.util.Arrays; 
import java.util.*;
class MaxWater { 


 // } Driver Code Ends


//User function Template for Java

// Return the maximum water that can be stored 
static int maxWater(int arr[], int n) 
{ 
    //Your code here
    if(n==0 || n==1 || n==2)
        return 0;
    int l=0, h=n-1, ans=0;
    while(l<h){
       int buildings=h-l-1, min;
       min = arr[l] < arr[h] ? arr[l] : arr[h];
       int curr = buildings * min;
       ans = ans < curr ? curr : ans;
       if(min == arr[l])
        l++;
       else
        h--;
    }
    return ans;
} 


// { Driver Code Starts.


	// Driver code 
	public static void main(String[] args) 
	{ 
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t-->0)
	    {
	        int n=sc.nextInt();
	        int height[]=new int[n];
	        for(int i=0;i<n;i++)
	        height[i]=sc.nextInt();
	        System.out.println(maxWater(height, n)); 
	    }
	

		
	} 
} 
  // } Driver Code Ends
