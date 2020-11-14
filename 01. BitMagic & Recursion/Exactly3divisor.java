import java.util.Scanner;

class Exactly3divisor
{
	public static int method(int n)
	{
		if(n == 0)
			return 0;
		else
		{
	        int total = 0;	        
	        for(int i=2;i<=n;i++)
	        {
	        	long l = (long)Math.sqrt(i);
	        	double d = Math.sqrt(i);
	        	boolean p_square = false, prime = true;
	        	if(l == d)
	        	{
	        		p_square = true;
	        		System.out.println(i + " is p_square: " + l);
	        		for(int j=2; j<l;j++)
	        		{
	        			if(l % j == 0)
	        			{
	        				prime = false;
	        				break;
	        			}
	        		}
	        		System.out.println(l + " is prime." + prime);
	        	}
	        	if(p_square == true && prime == true)
	        		total++;
	        }
	        return total;
	    }
	}
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.print(method(n));
	}
}