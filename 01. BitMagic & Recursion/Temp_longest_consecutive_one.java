//Initial Template for Java
import java.io.*;
import java.util.*;
//Position this line where user code will be pasted.
class Temp_longest_consecutive_one {
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    int n = sc.nextInt();
		    
		    ConsecutiveOne obj = new ConsecutiveOne();
		    
		    System.out.println(obj.maxConsecutiveOnes(n));
		}
	}
}

/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
class ConsecutiveOne{
    
    /*  Function to calculate the largest consecutive ones
    *   x: given input to calculate the largest consecutive ones
    */
    public static int maxConsecutiveOnes(int x) {
        
        // Your code here
        int count = 0;
        /* boolean pre = true;
        while(x != 0)
        {
            if(x % 2 == 0)
            { 
                pre = false;
                count = 0;
            }
            else
            {
                pre = true;
                count++;
            }
            x = x >> 1;
        }*/
        while(x != 0)
        {
            x = x & (x >> 1);
            count++;
        }
        return count;
    }
}
