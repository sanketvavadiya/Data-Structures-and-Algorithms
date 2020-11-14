import java.util.*;
import java.lang.*;
import java.io.*;

class UnionOFTwoSortedArrays {
	static void method(int arr[], int brr[], int n1, int n2)
	{
		int i = 0, j = 0, temp = 0;
		while(i < n1 && j < n2)
		{
			if(i > 0 && arr[i-1] == arr[i])
			{
				i++;
				continue;
			}
			if(j > 0 && brr[j-1] == brr[j])
			{
				j++;
				continue;
			}
			if(arr[i] < brr[j])
				System.out.print(arr[i++] + " ");
			else if(arr[i] > brr[j])
				System.out.print(brr[j++] + " ");
			else
			{
				System.out.print(arr[i] + " ");
				i++;
				j++;
			}
		}
		while(i<n1)
		{
			if(i == 0 || arr[i-1] != arr[i])
				System.out.print(arr[i] + " ");
			i++;
		}
		while(j<n2)
		{
			if(j == 0 || brr[j-1] != brr[j])
				System.out.print(brr[j] + " ");
			j++;
		}
	}
	public static void main (String[] args) throws IOException{
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s[] = br.readLine().trim().split("\\s+");
		int n1 = Integer.parseInt(s[0]);
		int n2 = Integer.parseInt(s[1]);

		int arr[] = new int[n1];
		int brr[] = new int[n2];

		String s1[] = br.readLine().trim().split(" ");
		for (int i=0;i<n1;i++) {
			arr[i] = Integer.parseInt(s1[i]);
		}

		String s2[] = br.readLine().trim().split(" ");
		for (int i=0;i<n2;i++) {
			brr[i] = Integer.parseInt(s2[i]);
		}

		method(arr, brr, n1, n2);
	}
}