import java.util.Scanner;
class Sliding_window_technique_imp
{
	public static boolean naive(int arr[], int n ,int sum)
	{
		for (int i=0;i<n;i++ ) {
			int curr_sum = 0;
			for(int j=i;j<n;j++)
			{
				curr_sum += arr[j];
				if(curr_sum == sum)
					return true;
			}
		}
		return false;
	}
	public static boolean efficient(int arr[],int n, int sum)
	{
		int curr_sum = 0;
		int j = 0;
		for(int i=0;i<n;i++)
		{
			if(curr_sum < sum)
				curr_sum += arr[i];
			if(curr_sum == sum)
				return true;
			else
			{
				curr_sum -= arr[j];
				if(curr_sum == sum)
					return true;
				j++;
			}
			System.out.println("curr_sum: " +curr_sum);
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		int sum = sc.nextInt();
		System.out.println("Nave: " + naive(arr, n, sum));
		System.out.println("Efficirnt: " +efficient(arr, n, sum));
	}	
}