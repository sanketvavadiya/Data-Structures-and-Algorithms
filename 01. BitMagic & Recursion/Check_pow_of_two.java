class Check_pow_of_two
{
	public static boolean brian_Kernighan(int n)
	{
		if(n == 0)
			return false;
		else
			return ((n & (n-1)) == 0);
	}
	public static boolean naive(int n)
	{
		if(n == 0)
			return false;
		else
		{
			while(n != 1)
			{
				if(n % 2 != 0)
					return false;
				n /= 2;
			}
			return true;
		}
	}
	public static void main(String [] args)
	{
		int n = 1025;
		System.out.println("Brian Kernighan:" + brian_Kernighan(n));
		System.out.println("Naive method: " + naive(n));
	}
}