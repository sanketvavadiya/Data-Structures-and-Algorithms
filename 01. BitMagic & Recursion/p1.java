/** Given n, find sum of first n natural number */

import java.util.Scanner;

class p1
{
	static void fun1(int n)
	{
		System.out.println("Using formula: " + (n*(n+1)/2));
	}
	static void fun2(int n, int sum)
	{
		System.out.print("Using two loops: ");
		for(int i=0;i<n;i++)
			for(int j=0;j<=i;j++)
				sum++;
		System.out.print(sum);
	}
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		for(int i=1;i<=n;i++)
			sum += i;
		System.out.println("Sum of first "+n+"number: " + sum);
		fun1(n);
		fun2(n, 0);
	}
}