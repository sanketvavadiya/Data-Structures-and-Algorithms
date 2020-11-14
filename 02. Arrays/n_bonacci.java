import java.util.Scanner;
class n_bonacci
{
	public static void method(int n, int m)
	{
		int arr[] = new int[n];
		for (int i=0;i<n-1 ;i++)
			arr[i] = 0;
		arr[n-1] = 1;
		for(int i = 0;i<m;i++)
		{
			if(i < n)
				System.out.print(arr[i] + " ");
			else
			{
				int sum = 0;
				for(int j = 0;j<n;j++)
					sum += arr[j];
				arr[i%n] = sum;
				System.out.print(sum + " ");
			}

		}
	}
	public static void efficeint(int n, int m)
	{
		int arr[] = new int[m];
		for(int i=0;i<m;i++)
			arr[i] = 0;
		arr[n - 1] = 1;
		arr[n] = 1;
		for (int i=n+1;i<m ;i++ )
			arr[i] = 2 * arr[i-1] - arr[i-n-1];
		for(int i=0;i<m;i++)
			System.out.print(arr[i] + " ");
	}
	public static void main(String[] args) {
		Scanner  sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.print("Naive: ");
		method(n, m);
		System.out.print("\nEfficient: ");
		efficeint(n, m);
	}
}