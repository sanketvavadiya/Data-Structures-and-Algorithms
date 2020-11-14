import java.io.*;
import java.util.*;
//Position this line where user code will be pasted.
class Temp_check_sparse {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    int n = sc.nextInt();
		    
		    Sparse obj = new Sparse();
		    
		    if(obj.isSparse(n)){
		        System.out.println("1");
		    } else {
                System.out.println("0");
		    }
		}
	}
}
/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
class Sparse{
    
    // Function to check if the given number is sparse or not
    public static boolean isSparse(int n){
        
        // Your code here
 		if((n & (n >> 1)) == 0)
 			return true;
 		else
 			return false; 
    }
    
}