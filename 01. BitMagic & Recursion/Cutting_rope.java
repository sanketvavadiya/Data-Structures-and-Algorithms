class Cutting_rope
{
	public static int rope(int n, int a, int b, int c)
	{
		if(n < 0)
			return -1;
		else if(n == 0)
			return 0;
		int res = Math.max(Math.max(rope(n - a, a, b, c), rope(n - b, a, b, c)), rope(n - c, a, b, c));
		if(res == -1)
			return -1;
		return res + 1;

	}
	public static void main(String [] str)
	{
		System.out.println(rope(5, 2, 5, 1));
	}
}