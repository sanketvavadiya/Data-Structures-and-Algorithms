import java.io.*;
import java.util.*;
class ArrayFrequency {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim()); // taking input size of array
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i]=Integer.parseInt(inputLine[i]); // input elements of array
		    }
		    
		    Frequency obj = new Frequency();
		    
		    obj.printFrequency(arr, n); // print frequency of elements 
		    System.out.println();
		}
	}
}

/*This is a function problem.You only need to complete the function given below*/
class Frequency{
    
    // Function to count frequencies of elements in the array
    // arr: input array
    // n: size of array
    public static void  printFrequency(int arr[], int n){
        
        // Your code here
        int freq[] = new int[n];
        for(int i=0;i<n;i++)
        	freq[arr[i] - 1]++;
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<n;i++)
        	sb.append(freq[i] + " ");
        System.out.print(sb);
    }
}
