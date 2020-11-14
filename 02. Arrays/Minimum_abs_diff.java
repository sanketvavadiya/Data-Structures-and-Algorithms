import java.io.*;
import java.util.*;
import java.lang.*;
//Position this line where user code will be pasted.
class Minimum_abs_diff {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		
		while(t-->0)
		{
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i]=Integer.parseInt(inputLine[i]);
		    }
		    
		    Difference obj = new Difference();
		    
		    System.out.println(obj.minAdjDiff(arr, n));
		}
	}
}

/*This is a function problem.You only need to complete the function given below*/

class Difference{
    
    // Function to find minimum adjacent difference
    // arr[]: input array
    // n: size of array
    public static int minAdjDiff(int arr[], int n) {
        
        // Your code here
        int minDiff = Math.abs(arr[1] - arr[0]);
        int diff = Math.abs(arr[1] - arr[0]);
        for(int i=1;i<n-1;i++)
        {
        	diff = Math.abs(arr[i] - arr[i+1]);
        	if(diff < minDiff)
        		minDiff = diff;
        }
        diff = Math.abs(arr[0] - arr[n-1]);
       	minDiff = minDiff > diff ? diff : minDiff;
       	return minDiff;
    }
}
