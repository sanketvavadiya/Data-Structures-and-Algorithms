import java.util.Scanner;

class Sorted_Rotated
{
	static int method(int arr[], int l, int h, int x)
	{
		int maxInd = findMax(arr, 0, h);
		System.out.println("max: " + arr[maxInd]);
		if(arr[maxInd] == x)
			return maxInd;
		if(arr[0] <= x)
			return binarySearch(arr, 0, maxInd, x);
		else
			return binarySearch(arr, maxInd+1, h, x);	
	}
	static int findMax(int arr[], int l , int h)
	{
		int maxInd = (l+h)/2;
		if(arr[maxInd] > arr[maxInd+1])
			return maxInd;
		if(arr[maxInd] < arr[0])
			return findMax(arr, l, maxInd-1);
		if(arr[maxInd] > arr[0])
			return findMax(arr, maxInd+1, h);
		return -1;
	}
	static int binarySearch(int arr[], int l ,int h, int x)
	{
		if(l <= h)
		{
			System.out.println("l: " + l + " h: " + h);
			int mid = (l + h)/2;
			System.out.println("mid: " + mid);
			if(x == arr[mid])
				return mid;
			if(x > arr[mid])
				return binarySearch(arr, mid+1, h, x);
			if(x < arr[mid])
				return binarySearch(arr, l, mid-1, x);
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
		System.out.println(method(arr, 0, n-1, x));
	}
}