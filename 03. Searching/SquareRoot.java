import java.util.Scanner;

class SquareRoot
{
	static int method(int n)
	{
		if(n == 0 || n == 1)
			return n;
		else
		{
			int start = 1, end = n, ans=0;
			while(start <= end)
			{
				int mid = (start+end)/2;
				if(mid*mid  == n)
					return mid;
				else if(mid*mid < n)
				{
					start = mid+1;
					ans = mid;
				}
				else
					end = mid-1;
			}
			return ans;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(method(n));
	}
}