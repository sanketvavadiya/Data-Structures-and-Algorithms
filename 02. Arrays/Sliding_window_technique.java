import java.util.Scanner;
class Sliding_window_technique
{
	public static int method(int arr[], int n, int k)
	{
		int max = 0;
		int record = 0;
		for(int i=0;i<=n-k;i++)
		{
			int sum = 0;
			for(int j=0;j<k;j++)
				sum += arr[record + j];
			max = max < sum ? sum : max;
			record++;
		}
		return max;
	}
	public static int efficient(int arr[], int n,int k)
	{
		int max_sum = 0;
		int curr_sum = 0;
		for (int i=0;i<k;i++) {
			curr_sum += arr[i];
		}
		for (int i=k; i<n; i++) {
			curr_sum = curr_sum + arr[i] - arr[i - k];
			max_sum = max_sum < curr_sum ? curr_sum : max_sum;
		}
		return max_sum;
	}
	// return given sum present in array with given k
	public static boolean sumPresent(int arr[], int n , int k)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter sum to check present: ");
		int sum = sc.nextInt();
		int curr_sum = 0;
		for (int i=0;i<k;i++) {
			curr_sum += arr[i];
		}
		if(curr_sum == sum)
			return true;
		for (int i=k; i<n; i++) {
			curr_sum = curr_sum + arr[i] - arr[i - k];
			if(curr_sum == sum)
				return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		System.out.println("Max: " + method(arr, n, k));
		System.out.println("efficient: " + efficient(arr, n, k));
		System.out.println("Sum present: " + sumPresent(arr, n, k));

	}
}