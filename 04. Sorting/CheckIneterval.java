import java.util.Scanner;
class Interval
{
	public int start, end;
	boolean checkIneterval(Interval temp)
	{
		if(this.end > temp.start)
			return true;
		else
			return false;
	}
}
class CheckIneterval
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		Interval [] arr = new Interval[n];
		for(int i = 0;i<n;i++)
		{
			arr[i] = new Interval();
			arr[i].start = sc.nextInt();
			arr[i].end = sc.nextInt();
		}

		for(int i=0;i<n-1;i++)
		{
			if(arr[i].checkIneterval(arr[i+1]))
				System.out.println(i + " and " + (i+1) + " overlapped");
			else
				System.out.println(i + " and " + (i+1) + " not overlapped");
		}
	}
}