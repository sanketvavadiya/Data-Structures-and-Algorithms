import java.io.*;
class Subarray_with_max_sum {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Kadane obj = new Kadane();
		    
		    System.out.println(obj.maxSubarraySum(arr, n));
		}
	}
}

/*This is a function problem.You only need to complete the function given below*/
class Kadane{
    
    // Function to find subarray with maximum sum
    // arr: input array
    // n: size of array
    int maxSubarraySum(int arr[], int n){
        
        // Your code here
        int max1 = Integer.MIN_VALUE,max2 = Integer.MIN_VALUE, max_end = 0;
        for(int i=0;i<n;i++)
        {
	       	max_end += arr[i];        	
	       	if(max1 < max_end)
	       		max1 = max_end;
	       	if(max_end < 0)
	       		max_end = 0;
        }
        int total_sum = 0;
        for(int i=0;i<n;i++)
        {
        	total_sum += arr[i];
        	arr[i] = -arr[i];
        }
        max_end = 0;
        for(int i=0;i<n;i++)
        {
	       	max_end += arr[i];        	
	       	if(max2 < max_end)
	       		max2 = max_end;
	       	if(max_end < 0)
	       		max_end = 0;
        }
        max2 += total_sum;
        return max1 > max2 ? max1 : max2;
    }
    
}
