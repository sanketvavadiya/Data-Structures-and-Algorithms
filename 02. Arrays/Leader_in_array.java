import java.util.*;
class Leader_in_array
{
	public static void naive(ArrayList<Integer> arr, int n)
	{
		for(int i=0;i<n;i++)
		{
			boolean flag = true;
			for(int j=i+1;j<n;j++)
				if(arr.get(j) > arr.get(i))
					flag = false;
			if(flag)
				System.out.print(arr.get(i) + " ");
		}
	}
	public static void efficient(ArrayList<Integer> arr, int n)
	{
		int curr_leader = arr.get(n-1);
		System.out.print(curr_leader + " ");
		for(int i = n-2; i>=0;i--)
		{
			if(arr.get(i) > curr_leader)
			{
				curr_leader = arr.get(i);
				System.out.print(curr_leader + " ");
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>(n);
		for(int i=0;i<n;i++)
			arr.add(sc.nextInt());
		System.out.print("Naive method: ");
		naive(arr, n);
		System.out.println();
		System.out.print("Efficient method: ");
		efficient(arr, n);
	}
}