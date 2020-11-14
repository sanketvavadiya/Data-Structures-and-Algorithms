import java.util.*;
import java.io.*;
import java.lang.*;

class RoofTop
{
    
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            
            int arr[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            for(int i = 0; i < n; i++)
              arr[(int)i] = Integer.parseInt(st[(int)i]);
              
            
            System.out.println(new Step().maxStep(arr, n));
        }
    }
    
    
}
    
    
// } Driver Code Ends
class Step{
    
    // Function to find the maximum steps
    // arr[]: input array
    // n: size of the array
    static int maxStep(int arr[], int n){
        
        // Your code here
        if(n==0 || n==1)
            return 0;
       int count = 0, pre=0;
        for(int i=0;i<n-1;i++)
        {
            if(arr[i]<arr[i+1])
                pre++;
            else if(arr[i]>=arr[i+1])
                pre=0;
            count = count < pre ? pre : count;
        }
        return count;
    }
    
}