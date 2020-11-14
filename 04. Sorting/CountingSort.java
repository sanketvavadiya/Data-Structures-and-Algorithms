import java.util.Scanner;
class CountingSort
{
	static void sort(int arr[], int n, int l, int r)
	{
		int k = r-l;
		System.out.println(k);
		int count[] = new int[k];
		for(int i=0;i<k;i++)
			count[i] = 0;
		for(int i=0;i<n;i++)
			count[arr[i]-l]++;
		for(int i=1;i<k;i++)
			count[i] = count[i] + count[i-1];
		
		int temp[] = new int[n];

		for(int i=n-1;i>=0;i--)
		{
			temp[count[arr[i]-l] - 1] = arr[i];
			count[arr[i]-l]--;
		}
		for(int i = 0;i<n;i++)
			System.out.print(temp[i] + " ");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();

		int l = sc.nextInt();
		int r = sc.nextInt();
		sort(arr, n, l, r);
	}
}