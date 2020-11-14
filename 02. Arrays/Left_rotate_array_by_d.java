import java.util.*;
class Left_rotate_array_by_d
{
	public static void method(ArrayList<Integer> arr, int n, int d)
	{
		if(d == 0)
			return;
		int temp = arr.get(0);
		for(int i=0;i<n-1;i++)
			arr.set(i, arr.get(i+1));
		arr.set(n-1, temp);
		method(arr, n, d-1);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>(n);
		for(int i = 0;i < n;i++)
			arr.add(sc.nextInt());
		method(arr, n, d);
		for(int i=0;i<n;i++)
			System.out.print(arr.get(i) + " ");
	}
}