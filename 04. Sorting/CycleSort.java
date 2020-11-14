import java.util.Scanner;
class CycleSort
{
	static void swap(int a, int b)
	{
		int temp = a;
		a = b;
		b = temp;
	}
	static void sort(int arr[], int n)
	{
		for(int cs = 0;cs<n-1;cs++)
		{
			int item = arr[cs];
			int pos = cs;
			for(int i=cs+1;i<n;i++)
				if(item > arr[i])
					pos++;
			int temp = arr[pos];
			arr[pos] = item;
			item = temp;
			while(cs != pos)
			{
				pos = cs;
				for(int i = cs+1;i<n;i++)
					if(item > arr[i])
						pos++;
				temp = arr[pos];
				arr[pos] = item;
				item = temp;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int []arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();

		sort(arr, n);
		for(int i=0;i<n;i++)
			System.out.print(arr[i] + " ");
	}
}