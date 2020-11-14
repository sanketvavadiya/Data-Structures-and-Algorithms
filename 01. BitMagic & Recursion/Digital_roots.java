//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;
class Digital_roots
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            System.out.println(new Digital().digitalRoot(n));
        }
    }
}
/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
class Digital
{
    // complete the function
    public static int digitalRoot(int n)
    {
        // add your code here
        if(n < 10)
        	return n;
        else
        	return digitalRoot(sumDigit(n));
    }
    public static int sumDigit(int n)
    {
    	int sum = 0;
    	while(n != 0)
    	{
    		sum += n % 10;
    		n /= 10;
    	}
    	return sum;
    }
}