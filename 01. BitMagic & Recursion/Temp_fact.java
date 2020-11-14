class Temp_fact
{
	public static void main(String [] args)
	{
		long n = 1902250258;
		int d = 0;
		while(n > 0)
		{
			d++;
			n /= 10;
		}
		System.out.println(d);
	}
}