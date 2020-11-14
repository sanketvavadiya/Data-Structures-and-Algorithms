import java.util.*;
import java.io.*;
import java.lang.*;

class LuckyNumber
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            
            System.out.println((new Solution().isLucky(n))? "1" : "0");
            new Solution().counter = 2;
        }
    }
}
// } Driver Code Ends
//User function Template for Java



class Solution
{
    // Complete the function
    // n: Input n
    // counter: variable has already been declared in driver code
    //          you just have to use this variable.
    static int counter = 2;
    
    // Return True if the given number is a lucky number else return False
    public static boolean isLucky(int n)
    {
        // Your code here
        
    }
}