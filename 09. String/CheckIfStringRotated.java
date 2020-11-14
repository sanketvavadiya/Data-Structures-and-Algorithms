// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class CheckIfStringRotated {
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t;
		t = sc.nextInt();
		String s12 = sc.nextLine();
		for(int i=0; i<t; i++){
		    String s1 = sc.nextLine();
		    String s2 = sc.nextLine();
		    
		    Rotation obj = new Rotation();
		    
		    boolean flag = obj.isRotated(s1, s2);
		    
		    if(flag == true) System.out.println("1");
		    else System.out.println("0");
		    
		}
	}
}// } Driver Code Ends


class Rotation{
    
    /*  Function to check if two strings are rotated
    *   s1, s2: input strings
    */
    public static boolean isRotated(String s1, String s2){
        // Your code here
        // String temp1 = s2.substring(2, s2.length());
        // String temp2 = s2.substring(0, 2);
        // String temp3 = s2.substring(0, s2.length()-2);
        // String temp4 = s2.substring(s2.length()-2, s2.length());
        // // System.out.println(temp1+temp2);
        // // System.out.println(temp4+temp3);
        // // System.out.println(temp4);
        // if(s1.equals(temp1+temp2) || s1.equals(temp4+temp3))
        //     return true;
        // else
        //     return false;
        String s = s1+s1;
        System.out.println(s.contains(s2));
        return true;
    }
    
}