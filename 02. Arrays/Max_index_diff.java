import java.io.*;
import java.util.*;
class Max_index_diff {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim()); // size of array
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
		    }
		    
		    MaxDifference obj = new MaxDifference();
		    
		    System.out.println(obj.maxIndexDiff(arr, n)); // print the result
		}
	}
}

/*This is a function problem.You only need to complete the function given below*/
class MaxDifference{
    
    // Function to find maximum difference of j-1
    // arr[]: input array
    // n: size of array
    static int maxIndexDiff(int arr[], int n) { 
        
        // Your code here
        int indexDiff = 0;
        for(int i=0;i<n;i++)
        	for(int j=i+1;j<n;j++)
        		if(arr[i] <= arr[j] && indexDiff < j - i)
        			indexDiff = j - i;
        return indexDiff;
    }
}
