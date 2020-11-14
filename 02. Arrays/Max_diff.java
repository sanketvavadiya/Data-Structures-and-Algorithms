import java.util.*;
class Max_diff
{
	public static int naive(ArrayList<Integer> arr, int n)
	{
		int max = arr.get(1) - arr.get(0);
		for(int j=1;j<n;j++)
		{
			for(int i=j - 1;i>=0;i--)
			{
				int diff = arr.get(j) - arr.get(i);
				if(max < diff)
					max = diff;
			}
		}
		return max;
	}
	public static int effiecient(ArrayList<Integer> arr, int n)
	{
		int res = arr.get(1)-arr.get(0);
		int minVal = arr.get(0);
		for(int j = 1;j<n;j++)
		{
			int diff = arr.get(j) - minVal;
			res = res < diff ? diff : res;
			minVal = minVal > arr.get(j) ? arr.get(j) : minVal;
		}
		return res;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>(n);
		for(int i=0;i<n;i++)
			arr.add(sc.nextInt());
		System.out.println("Naive: " + naive(arr, n));
		System.out.print("Efficient: " + effiecient(arr, n));
	}
}