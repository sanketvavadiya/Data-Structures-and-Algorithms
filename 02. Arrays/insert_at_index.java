import java.util.Scanner;
class insert_at_index
{
	public static void method(int arr[], int n , int index, int element)
	{
		for(int i=n;i>index;i--)
			arr[i] = arr[i-1];
		arr[index] = element;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n+1];
		for(int i =0;i<n;i++)
			arr[i] = sc.nextInt();
		int index = sc.nextInt();
		int element = sc.nextInt();
		method(arr, n, index, element);
		for(int i =0;i<n+1;i++)
			System.out.print(arr[i] + " ");	
	}
}