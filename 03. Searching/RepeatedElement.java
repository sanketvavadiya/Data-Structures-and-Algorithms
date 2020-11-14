import java.util.*;
import java.lang.*;
import java.io.*;
class RepeatedElement
 {
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    for(int i=0;i<t;i++){
	        int n = Integer.parseInt(br.readLine());
	        String l = br.readLine();
    		String[] sarr = l.split(" ");
    		int[] arr = new int[sarr.length];
    		for(int i1=0;i1<arr.length;i1++){
    			arr[i1] = Integer.parseInt(sarr[i1]);
    		}
    		
            Repeated obj = new Repeated();
            
            obj.twoRepeated(arr, n);
            	System.out.println();
    		
    		
	    }
	 }
}

/*This is a function problem.You only need to complete the function given below*/
class Repeated{
    // Function to find the repeated element in the array
    // arr[]: input array
    // n: size of array
    static void twoRepeated(int arr[], int n){
        
        // Your code here
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n+2;i++)
        {
            if(arr[Math.abs(arr[i])] > 0)
                arr[Math.abs(arr[i])] *= -1;
            else
                sb.append(Math.abs(arr[i]) + " ");
        }
        System.out.print(sb);
    }
    
}