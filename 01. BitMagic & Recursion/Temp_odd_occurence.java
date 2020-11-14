// find which element occur odd number of times it is confirm that there is exact onr element which occure odd times
class Temp_odd_occurence
{
	public static int NaiveMeth(int arr[])
	{
		int ans = 0;
		for(int i=0;i<arr.length;i++)
		{
			int count = 0;
			for(int j=i;j<arr.length;j++)
				if(arr[i] == arr[j])
					count++;
			if(count % 2 != 0)
			{
				ans = arr[i];
				break;
			}
		}
		return ans;
	}

	public static int EffMeth(int arr[])
	{
		int ans = 0;
		for(int i=0;i<arr.length;i++)
		{
			ans = ans ^ arr[i];
			// System.out.println("Iteration: " + i + " Answer: " + ans);
		}
		return ans;
	}
	public static void main(String [] args)
	{
		int [] arr = {4, 3, 4, 4, 4, 5, 5, 3, 3};
		System.out.println("Naive method: " + NaiveMeth(arr));
		System.out.print("Efficient method: " + EffMeth(arr));
	}
}