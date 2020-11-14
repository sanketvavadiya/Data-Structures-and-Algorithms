import java.util.*;
import java.lang.*;
import java.io.*;

class CountRepeated {
	public static void main (String[] args) throws IOException{
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while(t-- > 0)
		{
			int n = Integer.parseInt(br.readLine());
			int arr[] = new int[n];
			String s[] = br.readLine().trim().split("\\s+");

			for(int i=0;i<n;i++)
				arr[i] = Integer.parseInt(s[i]);

			new Repeated().method(arr, n);
		}
	}
}

class Repeated
{
	static void method(int arr[], int n)
	{
	    if(n==0 || n==1){
	        System.out.println(-1 + " " + -1);
	        return;
	    }
	    int l=0, h=n-1, mid=0;
	    if(arr[h]==arr[0]+h){
	        System.out.println(-1 + " " + -1);
	        return;
	    }
		while(l<=h){
			mid=(l+h)/2;
			if(arr[mid]==arr[0]+mid)
				l=mid+1;
			else if((mid!=0 && arr[mid]==arr[mid-1]) || (mid!=n-1 && arr[mid]==arr[mid+1]))
				break;
			else
				h=mid-1;
		}
		int max=arr[0]+n-1;
		int count = max - arr[n-1] + 1;
		System.out.println(arr[mid] + " " + count);
	}
}