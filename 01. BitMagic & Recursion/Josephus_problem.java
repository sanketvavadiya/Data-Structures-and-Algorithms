import java.util.Scanner;
class Josephus_problem
{
	public static int method(int n, int k)
	{
		if(n == 0)
			return 0;
		return (method(n-1, k) + k) % n;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(method(n, k));
	}
}