import java.util.Scanner;

class Total_ocurrences
{
	static int count = 0;
	static int leftMost(int arr[], int l, int h, int x)
	{		
		if(l <= h)
		{
			int mid = (l + h)/2;
			if(x == arr[mid])
			{
				if(mid != 0 && arr[mid-1] == x)
					return leftMost(arr, l, mid-1, x);
				else
					return mid;
			}
			if(x > arr[mid])
				return leftMost(arr, mid+1, h, x);
			if(x < arr[mid])
				return leftMost(arr, l, mid-1, x);
		}
		return -1;
	}
	static int rightMost(int arr[], int n, int l, int h, int x)
	{
		if(l <= h)
		{
			int mid = (l + h)/2;
			if(x == arr[mid])
			{
				if(mid != 0 && arr[mid+1] == x)
					return rightMost(arr, n, mid+1, h, x);
				else
					return mid;
			}
			if(x > arr[mid])
				return rightMost(arr, n, mid+1, h, x);
			if(x < arr[mid])
				return rightMost(arr, n, l, mid-1, x);
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		System.out.println("Total_ocurrences: " + (rightMost(arr, n, 0, n-1, x) - leftMost(arr, 0, n-1, x) + 1));
	}
}