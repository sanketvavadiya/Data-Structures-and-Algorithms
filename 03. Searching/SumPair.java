// given unsorted array and sum find if there exist a pair int array that is equal to given sum
import java.util.Scanner;
 
class SumPair
{
	static boolean method(int arr[], int n, int sum)
	{
		for(int i=0;i<n;i++)
		{
			for (int j=i+1; j<n; j++) {
				if (arr[i] + arr[j] == sum) {
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n;i++)
			arr[i] =sc.nextInt();
		System.out.println(method(arr, n, sum));
	}
}