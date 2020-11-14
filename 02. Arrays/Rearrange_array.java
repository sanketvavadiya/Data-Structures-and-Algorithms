import java.util.*;
import java.lang.*;
import java.io.*;
class Rearrange_array {
	public static void main (String[] args)throws IOException
	{
// 		Scanner in = new Scanner(System.in);
        
// 		int t = in.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
		
		while(t-- >0)
		{
		    int n = Integer.parseInt(read.readLine());
		    int[] temp= new int[n];
		    
		    String str[] = read.readLine().trim().split(" ");
		    for(int i=0;i<n;i++)
		        temp[i] = Integer.parseInt(str[i]);
		    
		    // StringBuffer sb = new StringBuffer();
		    
		    RearrangeAlternate obj = new RearrangeAlternate();
		    
		    obj.rearrange(temp, n);
		    StringBuffer sb = new StringBuffer();
		    for(int i =0; i < n; i++)
		     sb.append(temp[i] + " ");
		    System.out.println(sb);
		}
	}
}

/*This is a function problem.You only need to complete the function given below*/
class RearrangeAlternate{
    
    // This function wants you to rearrange the temp array as required
    // and returns a StringBuffer with all elements of modified temp array
    // appended to it.
    // temp: input array
    // n: size of array
    public static void rearrange(int arr[], int n){
        
        // Your code here
        for(int i=0;i<n;i+=2)
        {
        	if(i != n-1)
        	{
        		int temp = arr[i];
        		arr[i] = arr[n-1];
        		for(int j=n-1;j>i;j--)
        			arr[j] = arr[j-1];
        		arr[i+1] = temp;
        	}
        }
    }
    
}
