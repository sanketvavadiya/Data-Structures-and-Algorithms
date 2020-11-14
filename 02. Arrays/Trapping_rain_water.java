import java.util.*;
class Trapping_rain_water
{
	public static int method(ArrayList<Integer> arr, int n)
	{
		int water = 0;
		int i;
		for(i=1;i<n-1;i++)
		{
			// System.out.println("At rod: " + i);
			int left_max = arr.get(i - 1);
			int right_max = arr.get(i + 1);
			int curr_count = 0;
			for(int j = 0;j<i;j++)
				left_max = left_max < arr.get(j) ? arr.get(j) : left_max;
			for(int j = i+1;j<n;j++)
				right_max = right_max < arr.get(j) ? arr.get(j) : right_max;
			// System.out.println("left_max: " + left_max);
			// System.out.println("right_max: " + right_max);
			curr_count = left_max < right_max ? left_max : right_max;
			curr_count -= arr.get(i);
			water += curr_count > 0 ? curr_count : 0;
			// System.out.println("count: " + water);
			// System.out.println();
		}
		return water;
	}
	public static int efficient(int []arr, int n)
	{
		int water = 0;
		int []left_max = new int[n];
		left_max[0] = arr[0];
		for(int i=1;i<n-1;i++)
			left_max[i] = left_max[i - 1] < arr[i] ? arr[i] : left_max[i-1];
		int right_max[] = new int[n];
		right_max[n-1] = arr[n-1];
		for(int i = n-2;i>0;i--)
			right_max[i] = right_max[i+1] < arr[i] ? arr[i] : right_max[i+1];
		for(int i=0;i<n;i++)
		{
			System.out.println("left_max at: " + i + " is " + left_max[i]);
			System.out.println("right_max at: " + i + " is " + right_max[i]);
			System.out.println();
		}
		for(int i=1;i<n-1;i++)
		{
			int min = left_max[i] < right_max[i] ? left_max[i] : right_max[i];
			min -= arr[i];
			water += min;
		}
		return water;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// short t = sc.nextShort();
		// while(t-- > 0)
		// {
			int n = sc.nextInt();
			int [] arr =  new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			// System.out.println("Naive: " + method(arr, n));
			System.out.println("efficient: " + efficient(arr, n));
		// }
	}
}