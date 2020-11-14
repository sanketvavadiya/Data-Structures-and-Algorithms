/* Given array of size N containing elements [1, ..., N+1]
   find missing element from array. */
class Missing_element
{
	public static int method(int N, int arr[])
	{
		int ans = 0;
		for(int i=1;i<=N+1;i++)
		{
			boolean found = false;
			for(int j=0;j<N;j++)
			{
				if(arr[j] == i)
				{
					found = true;
					break;
				}
			}
			if(!found)
				ans = i;
		}	
		return ans;
	}
	public static int XOR_meth(int N, int arr[])
	{
		int ans = 0;
		for(int i=1;i<=N+1;i++)
			ans = ans ^ i;
		for(int i=0;i<N;i++)
			ans = ans ^ arr[i];
		return ans;
	}
	public static void main(String [] args)
	{
		int N = 10;	//size of array
		int [] arr = {7, 6, 2, 4, 3, 1, 9, 5, 10, 11};	//array contain members from [1, ..., 6] missing one element
		System.out.println("Missing element(Naive method): " + method(N, arr));
		System.out.println("Using XOR Operator: " + XOR_meth(N, arr));
	}
}