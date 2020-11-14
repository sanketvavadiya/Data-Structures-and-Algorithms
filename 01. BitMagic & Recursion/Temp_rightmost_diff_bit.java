//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;
class Temp_rightmost_diff_bit{
    
    // Function to get rightmost set bit
    public static int getRightMostSetBit(int n) {
        if(n==0)
            return 0;
        
        return (int)(Math.log(n & -n)/Math.log(2.0)) + 1; //finding the rightmost set bit of a number
    }
    
    //Position this line where user code will be pasted.
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int m,n;
		while(t-->0) {
		    m = sc.nextInt();
		    n = sc.nextInt();
		    System.out.println(posOfRightMostDiffBit(m, n));
		}
	}



/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
/*  function to find position of rightmost different bit
*   m, n : Integers to find rightmost different bits
*   You can have a look in the locked code for information
*   regarding other functions including driver code
*/ 
	public static int posOfRightMostDiffBit(int m, int n) {
	        
	    // Your code here        
	    int xor = m ^ n;
	    if(xor == 0)
	    	return -1;
	    else
	    {
	    	int k = 0;
	    	while(true)
	    	{
	    		if((xor & (1 << k)) == 0)
	    			k++;
	    		else
	    			return k + 1;
	    	}
	    }	        
	}
}