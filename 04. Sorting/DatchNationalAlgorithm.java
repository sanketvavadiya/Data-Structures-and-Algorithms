import java.util.Scanner;
class DatchNationalAlgorithm
{
	static void sort(int arr[], int lr, int hr)
	{
		int n = arr.length;
		int l = 0, mid = 0, h = n-1;
		while(mid <= h)
		{
			if(arr[mid] < lr)
			{	
				int temp = arr[mid];
				arr[mid] = arr[l];
				arr[l] = temp;
				l++;
				mid++;
			}

			else if(arr[mid] >= lr && arr[mid] < hr)
			{
				mid++;
			}

			else
			{
				int temp = arr[mid];
				arr[mid] = arr[h];
				arr[h] = temp;
				h--;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();

		int lr = sc.nextInt();
		int hr = sc.nextInt();
		sort(arr, lr, hr);
		for(int i=0;i<n;i++)
			System.out.print(arr[i] + " ");
	}
}