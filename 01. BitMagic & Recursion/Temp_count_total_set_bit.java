//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;
//Position this line where user code will be pasted.
// Driver code
class Temp_count_total_set_bit {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int x, n;
		while(t-->0) {
	        n = sc.nextInt();
		    CountBits obj = new CountBits();
		    System.out.println(obj.countSetBits(n));
		}
	}
}


/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
class CountBits{
    
    // Function to count number of set bits
    public static int countSetBits(int n){
    
        // Your code here
        int count = 0;
        for (int i=0;i<=n ;i++)
        {
        	int temp = i;
        	while(temp != 0)
        	{
        		temp = temp & (temp - 1); //  Brian Kernighan’s Algorithm
        		count++;
        	}
        }
        return count; 
    }
}