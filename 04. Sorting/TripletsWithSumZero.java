import java.util.*;
class TripletsWithSumZero{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			Triplet g=new Triplet();
			if(g.findTriplets(a,n))
				System.out.println("1");
			else
				System.out.println("0");
			
		}
	}
}// } Driver Code Ends
/*Complete the function below*/


class Triplet
{
    // Function to check if triplet is present 
    // arr[]: input array
    // n: size of the array
	public boolean findTriplets(int arr[] , int n)
    {
        //add code here.
        for(int i=0;i<n-2;i++)
        {
        	for(int j=i+1;j<n-1;j++)
        	{
        		int sum=arr[i]+arr[j];
        		for(int k=j+1;k<n;k++)
		        	if(sum + arr[k] == 0)
		        		return true;
		    }
        }
        return false;
    }
}