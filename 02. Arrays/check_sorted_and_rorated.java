import java.util.*;
import java.io.*;
import java.lang.*;
//Position this line where user code will be pasted.
class check_sorted_and_rorated {
    
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine()); // input size of array
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split("\\s+");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
		    }
		   
		 SortedRotated obj = new SortedRotated();
        
        if(!(obj.checkRotatedAndSorted(arr, n)))
            System.out.println("No"); // print the result
        else
            System.out.println("Yes");
		}
	}
}

/*This is a function problem.You only need to complete the function given below*/
class SortedRotated{    
    
    // Function to check if array is sorted and rotated
    // arr[]: input array
    // num: size of array
    public static boolean checkRotatedAndSorted(int arr[], int n){
        
        // Your code here
        int minIndex = 0;
        int maxIndex = 0;
        for(int i=1;i<n;i++)
        {
        	if(arr[minIndex] > arr[i])
        		minIndex = i;
        	if(arr[maxIndex] < arr[i])
        		maxIndex = i;
        }
        if(minIndex - maxIndex == 1)
        {
        	for(int i=0;i<maxIndex;i++)
        		if(arr[i] > arr[i+1])
        			return false;
        	for(int i=minIndex;i<n-1;i++)
        		if(arr[i] > arr[i+1])
        			return false;
        	if(arr[n-1] > arr[0])
        		return false;
        	return true;
        }
        else if(maxIndex - minIndex == 1)
        {
        	for(int i=maxIndex;i<n-1;i++)
        		if(arr[i] < arr[i+1])
        			return false;
        	for(int i=0;i<minIndex;i++)
        		if(arr[i] < arr[i+1])
        			return false;
        	if(arr[n-1] < arr[0])
        		return false;
        	return true;
        }
        else
        	return false;
    }
}
