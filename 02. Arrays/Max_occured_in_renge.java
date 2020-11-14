import java.io.*;
import java.util.*;
import java.lang.*;
class Max_occured_in_renge {
        
    	public static void main (String[] args) throws IOException{
    	    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    int L[] = new int[n];
		    int R[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        L[i]=Integer.parseInt(inputLine[i]);
		    }
		    inputLine = br.readLine().trim().split(" ");
		    int maxx = Integer.MIN_VALUE;
		    for(int i=0; i<n; i++){
		        R[i]=Integer.parseInt(inputLine[i]);
		        if(R[i] > maxx){
		            maxx=R[i];
		        }
		    }
		    
		    MaxOccur obj = new MaxOccur();
		    
		    System.out.println(obj.maxOccured(L, R, n, maxx));
		}
	}
	
}
//Position this line where user code will be pasted.

/*This is a function problem.You only need to complete the function given below*/
// L[] and R[] are input ranges
// n : size of array
// maxx: maximum element in R[]
// arr[]: declared globally with size equal to 1000000
class MaxOccur{
    
    public static int maxOccured(int L[], int R[], int n, int maxx){    	
        int arr[] = new int[maxx+1];
        for(int i=0;i<=maxx;i++)
        	arr[i] = 0;
        for(int i=0;i<n;i++)
        	for(int j=L[i];j<=R[i];j++)
        		arr[j]++;

        int maxOccuredElement = 0;
        int count = arr[0];
        
        for(int i=1;i<=maxx;i++)
        	if(count < arr[i])
        	{
        		maxOccuredElement = i;
        		count = arr[i];
        	}
        return maxOccuredElement;
    }
    
}