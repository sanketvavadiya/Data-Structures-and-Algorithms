import java.util.*;
class BuckerSort
{
	static void sort(ArrayList <Integer> arr, int n, int k)
	{
		int max = Collections.max(arr);
		max++;
		ArrayList <ArrayList <Integer>> bkt = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<n;i++)
		{
			int bi = (arr.get(i)*k)/max;
			bkt.get(bi).add(arr.get(i));
		}

		int index = 0;
		for(int i=0;i<k;i++)
			for(int j=0;j<bkt.get(i).size();j++)
				arr.set(index++, bkt.get(i).get(j));
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList <Integer> arr = new ArrayList<Integer>();
		for(int i=0;i<n;i++)
			arr.add(sc.nextInt());
		int k = sc.nextInt();
		sort(arr, n, k);
		for(int i=0;i<n;i++)
			System.out.print(arr.get(i));
	}
}