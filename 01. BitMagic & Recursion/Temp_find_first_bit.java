//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class Temp_find_first_bit {
    
    //Position this line where user code will be pasted.
    
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			System.out.println(getFirstSetBitPos(n));
		}
	}

/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
/*  Function to find position with first set bit
*   n: input integer
*/
    public static int getFirstSetBitPos(int n){
            
        // Your code here
        int k = 0;
        while(true)
        {
            if((n & (1 << k)) == 0)
                k++;
            else
                return k+1;
        }
        // return -1;
    }
}