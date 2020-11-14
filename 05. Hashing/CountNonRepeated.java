import java.util.*;
import java.io.*;
import java.lang.*;

class CountNonRepeated
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- >0)
        {
            int n=sc.nextInt();
            int arr[] = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
                
            
            System.out.println(new Hashing().countNonRepeated(arr, n));
        }
    }
}
// } Driver Code Ends
//User function Template for Java

class Hashing
{
    // Function to count non-repeated elements in the array
    // arr[]: input array
    // n: size of array
    static long countNonRepeated(int arr[], int n)
    {
        // add your code
        HashMap <Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i=0;i<n ;i++) {
        	if(!hm.containsKey(arr[i]))
        		hm.put(arr[i], 1);
        	else{
        		int val = hm.get(arr[i]);
        		hm.replace(arr[i], ++val);
        	}
        }

        int count=0;
        for(Map.Entry<Integer, Integer> e : hm.entrySet())
        	if(e.getValue() == 1)
        		count++;
        return count;
    }
}