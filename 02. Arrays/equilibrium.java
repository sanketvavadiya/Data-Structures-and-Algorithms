import java.util.Scanner;
class equilibrium
{
	public static int method(int arr[], int n)
	{
		int pre_sum[] = new int[n];
		pre_sum[0] = arr[0];
		for(int i=1;i<n;i++)
		{
			pre_sum[i] = pre_sum[i-1] + arr[i];
			System.out.print(pre_sum[i] + " ");
		}
		if(pre_sum[n-1] - pre_sum[0] == 0)
			return 1;
		else if(pre_sum[n-2] == 0)
			return n;
		for(int i=1;i<n-1;i++)
		{
			if(pre_sum[i-1] == (pre_sum[n-1]-pre_sum[i]))
				return i+1;
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		System.out.println(method(arr, n));
	}
}