import java.util.*;
class Peak_element{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++)
				a[i]=sc.nextInt();
		
			int A=new Peak().peakElement(a,n);
			int f=0;
			if(n==1)
			f=1;
			else
			if(A==0 && a[0]>=a[1])
			f=1;
			else if(A==n-1 && a[n-1]>=a[n-2])
			f=1;
			else if(a[A] >=a[A+1] && a[A]>= a[A-1])
			f=1;
			else
			f=0;
			System.out.println(f);
		}
	}
}

/*This is a function problem.You only need to complete the function given below*/
/*Complete the function below*/
class Peak
{
	// Function to find the peak element
	// a[]: input array
	// n: size of array a[]
	public int peakElement(int[] arr,int n)
    {
       //add code here.
       int l = 0;
		int h = n-1;
		while(l<=h)
		{
			int mid = (l+h)/2;
			if(l == h-1)
			    return arr[l] > arr[h] ? l : h;
			if(mid == l || (arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]))
				return mid;
			else if(arr[mid] < arr[mid+1])
			{
				l = mid+1;
				continue;
			}
			else if(arr[mid] <  arr[mid-1])
			{
				h = mid-1;
				continue;
			}
		}
		return 0;
		/*for(int i=1;i<n;i++)
		{
			if(i != n-1 && arr[i] > arr[i+1] && arr[i] > arr[i-1])
				return i;
		}
		if(arr[0] > arr[1])
			return 0;
		return 1;*/
    }
}