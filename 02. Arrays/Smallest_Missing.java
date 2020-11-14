import java.util.*;
//Position this line where user code will be pasted.
class Smallest_Missing
{   
    public static void main (String[] args) 
    {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++)
				arr[i]=sc.nextInt();
				
			Missing obj = new Missing();
			int missing = obj.missingNumber(arr,n);
			System.out.println(missing);
		}
    }
}

/*This is a function problem.You only need to complete the function given below*/
class Missing{
    
    // function to find first positive missing number
    static int missingNumber(int arr[], int size)
    {
        // Your code here
        // You can add utility functions (if required)
        int missingElement = 1;
        for(int i=0;i<size;i++)
        {
        	if(missingElement == arr[i])
        	{
        		i=0;
        		missingElement++;
        	}
        }
        return missingElement;
    }
    
}
