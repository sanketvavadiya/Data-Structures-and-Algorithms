class Power_set_using_recursion
{
	static void fun(String str, String curr, int index)
	{
		if(index == str.length())
		{
			System.out.println(curr);
			return;
		}
		fun(str, curr, index + 1);
		fun(str, curr + str.charAt(index), index + 1);
	}
	public static void main(String[] args) {
		fun("abc", "", 0);
	}
}