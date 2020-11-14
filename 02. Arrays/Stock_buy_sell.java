import java.util.*;
class Stock_buy_sell
{
	public static void efficient(ArrayList<Integer> arr, int n)
	{
		boolean sell = false, buy = true, flag = false;
		for(int i=0;i<n-1;i++)
		{
			if(arr.get(i) < arr.get(i+1) && buy == true)
			{
				buy = false;
				System.out.print("(" + i);
				sell = true;
				flag = true;
			}
			if(arr.get(i) > arr.get(i+1)&& sell == true)
			{
				sell = false;
				System.out.print(" " + i + ") ");
				buy = true;
			}
		}
		if(sell)
				System.out.print(" " + (n-1) + ") ");
		if(!flag)
			System.out.print("No Profit")
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		short t = sc.nextShort();
		while(t-- > 0)
		{
			int n = sc.nextInt();
			ArrayList<Integer> arr =  new ArrayList<Integer>(n);
			for(int i=0;i<n;i++)
				arr.add(sc.nextInt());
			efficient(arr, n);
			System.out.println();
		}
	}
}