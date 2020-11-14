/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class MedianOfTwoArray {
	public static void main (String[] args) throws IOException{
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while(t-- > 0)
		{		
			String st[] = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(st[0]);
			int m = Integer.parseInt(st[1]);

			String st1[] = br.readLine().trim().split("\\s+");
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = Integer.parseInt(st1[i]);

			String st2[] = br.readLine().trim().split("\\s+");
			int brr[] = new int[m];
			for (int i=0; i<m; i++) {
				brr[i] = Integer.parseInt(st2[i]);
			}

			System.out.println(new Demo().method(arr, n, brr, m));
		}
	}
}

class Demo
{
	static int method(int arr[], int n, int brr[], int m)
	{
		int i = 0, j = 0, k = 0, totalEle = n+m;
		int merge[] = new int[totalEle];
		while(i < n && j < m)
		{
			if(arr[i] < brr[j])
			{
				merge[k] = arr[i];
				i++;
			}
			else
			{
				merge[k] = brr[j];
				j++;
			}
			k++;
		}
		while(i<n)
		{
			merge[k] = arr[i];
			i++;
			k++;
		}
		while(j < m)
		{
			merge[k] = brr[j];
			j++;
			k++;
		}
		
		if(totalEle % 2 == 0)
			return (merge[totalEle/2] + merge[totalEle/2 - 1])/2;

		else
			return merge[totalEle/2];
	}
}