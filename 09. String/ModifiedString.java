// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class ModifiedString
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            String a = "";
            a = sc.next();
            System.out.println(new solve().modified(a));
        }
    }
}// } Driver Code Ends


class solve{
    public static long modified(String a){
        // Your code here
        int ans = 0;
        for (int i=2; i<a.length(); i++) {
            boolean flag=false;
            if(a.charAt(i)==a.charAt(i-1) && a.charAt(i)==a.charAt(i-2))
                flag = true;
            if(flag){
                ans++;
                i++;
            }
        }
        return ans;
    }
}