import java.util.*;
class Power_set
{
	public static void method(String str)
	{
		int n = str.length();
		for(int i=0; i<Math.pow(2, n); i++)
		{
			for(int j=0;j<n;j++)
				if((i & (1 << j)) != 0)
					System.out.print(str.charAt(j));
			System.out.println();
		}
	}
	public static void main(String[] args) {
		String str = "abc";
		System.out.println("Subsets: ");
		method(str);
	}
}