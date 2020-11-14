import java.io.*;
class InversePairInArray
{
	public static int inverse(int arr[], int l, int r)
	{
		int res = 0;
		if(r > l)
		{
			int mid = l + (r - l)/2;
			// System.out.println("l: "+l+" mid: "+mid+" r: "+r);

			// System.out.println("left side l: "+l+" mid: "+mid);
			res += inverse(arr, l, mid);

			// System.out.println("After first");
			// System.out.println("right side l: "+(mid+1)+" r: "+r);
			res += inverse(arr, mid+1, r);

			// System.out.println("After second");
			// System.out.println("calling merge l: "+l+" mid: "+mid+" r: "+r);
			res += mergeAndCount(arr, l, mid, r);
			// System.out.println("All complete");
		}
		return res;
	}
	public static int mergeAndCount(int arr[], int l, int mid, int r)
	{
		int n1 = mid - l + 1, n2 = r - mid;
		int left[] = new int[n1];
		int right[] = new int[n2];

		for(int i=0;i<n1;i++)
			left[i] = arr[l + i];
		for(int i=0;i<n2;i++)
			right[i] = arr[mid+i+1];

		int i = 0, j = 0, k = l, res = 0;
		while(i < n1 && j < n2)
		{
			if(left[i] <= right[j])
				arr[k++] = left[i++];
			else{
				arr[k++] = right[j++];
				res += n1-i;
			}
		}

		while(i < n1)
			arr[k++] = left[i++];
		while(j < n2)
			arr[k++] = right[j++];
		return res;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s[] = br.readLine().trim().split(" ");
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(s[i]);
		System.out.println(inverse(arr, 0, n-1));
	}
}