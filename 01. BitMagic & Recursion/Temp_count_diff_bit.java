import java.util.*;
import java.lang.*;
import java.io.*;
//Position this line where user code will be pasted.
// Driver class
class Temp_count_diff_bit {
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int m, n;
		long ans = 0; // initialise ans to 0
		while(t-->0) {
		    m = sc.nextInt();
		    n = sc.nextInt();
		    CountBitFlip obj = new CountBitFlip();
		    System.out.println(obj.countBitsFlip(m, n));
		}
	}
}


/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
class CountBitFlip{
    
    // Function to count number of bits to 
    // be flipped to convert A to B
    public static int countBitsFlip(int a, int b){
        
        // Your code here
        int xor = a ^ b;
        int count = 0;
        while(xor != 0)
        {
        	xor = xor & (xor - 1);
        	count++;
        }
        return count;
    }
    
    
}