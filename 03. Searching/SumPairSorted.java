// given sorted array and sum find if there exist a pair int array that is equal to given sum
import java.util.Scanner;

class SumPairSorted
{
	static boolean method(int arr[], int n, int sum)
	{
		int left = 0, right = n-1;
		while(left<right)
		{
			int curr_sum = arr[left] + arr[right];
			if(curr_sum == sum)
				return true;
			if(curr_sum > sum)
				right--;
			else
				left++;
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