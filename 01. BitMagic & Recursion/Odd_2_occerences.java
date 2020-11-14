/** given array, there is exactly two elements 
	which appears odd times find these two numbers */

class Odd_2_occerences
{
	public static void NaiveMeth(int arr[])
	{
		int pre = 0;
		for(int i=0;i<arr.length;i++)
		{
			int count = 0;
			if(pre != arr[i])
				for(int j=0;j<arr.length;j++)
					if(arr[i] == arr[j])
						count++;
			if(count % 2 != 0)
			{
				System.out.print(arr[i] + "\t");
				pre = arr[i];
			}
		}
	}
	public static void XOR_meth(int arr[])
	{
		int xor = 0;
		for(int i=0;i<arr.length;i++)
			xor = xor ^ arr[i];
		// find right most set Bit
		int set_bit = xor & (~(xor - 1));
		int res1 = 0, res2 = 0;
		for(int i=0;i<arr.length;i++)
		{
			if((arr[i] & set_bit) != 0)
				res1 = res1 ^ arr[i];
			else
				res2 = res2 ^ arr[i];
		}
		System.out.print(res1 + "\t" + res2);
	}
	public static void main(String[] args) {
		int [] arr = {1, 3, 4, 5, 5, 6, 4, 1, 3, 3, 3, 5};
		System.out.print("Naive Method: \t");
		NaiveMeth(arr);
		System.out.println("\nEfficient Method: \t");
		XOR_meth(arr);
	}
}