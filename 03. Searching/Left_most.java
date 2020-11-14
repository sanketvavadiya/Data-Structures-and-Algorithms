import java.util.Scanner;
class Left_most
{
	static int method(int arr[], int l, int h, int x)
	{
		/*if(l <= h)
		{
			int mid = (l + h)/2;
			if(x == arr[mid])
			{
				if(mid != 0 && arr[mid-1] == x)
					return method(arr, l, mid-1, x);
				else
					return mid;
			}
			if(x > arr[mid])
				return method(arr, mid+1, h, x);
			if(x < arr[mid])
				return method(arr, l, mid-1, x);
		}
		return -1;*/
		while(l <= h)
		{
			System.out.println("l: " + l + " h: " + h);
			int mid = (l + h)/2;			
			System.out.println("mid: " + mid);
			if(x == arr[mid])
			{
				if(mid != 0 && arr[mid-1] == x)
				{
					h = mid - 1;
					continue;
				}
				else
					return mid;
			}
			if(x > arr[mid])
			{
				l = mid + 1;
				continue;
			}
			if(x < arr[mid])
			{
				h = mid - 1;
				continue;
			}
			return -1;
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		System.out.println(method(arr, 0, n-1, x));
	}
}