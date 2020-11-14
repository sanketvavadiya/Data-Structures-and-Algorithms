// given sorted array having infinite element find index of given value
import java.util.Scanner;

class Infinite_array
{
	static int method(int arr[], int x)
	{
		if(arr[0] == x)
				return 0;
		int i = 1;		
		while(arr[i] < x)
		{
			if(arr[i] == x)
				return i;
			i *= 2;
		}
		if(arr[i] > x)
			i = binaySearch(arr, 0, i, x);
		return i;
	}
	static int binaySearch(int arr[], int l, int h, int x)
	{
		if(l <= h)
		{
			int mid = (l+h)/2;
			if(arr[mid] == x)
				return x;
			else if(arr[mid] > x)
				return binaySearch(arr, l, mid-1, x);
			else if(arr[mid] < x)
				return binaySearch(arr, mid+1, h, x);
			return -1;
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		System.out.println(method(arr, x));
	}
}