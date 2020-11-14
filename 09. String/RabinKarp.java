// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class RabinKarp
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- >0)
        {
            String s = "", p = "";
            s = sc.next();
            p = sc.next();
            
            int q = 101;
            
            match obj = new match();
            
            if(obj.search(p, s, q) == true)
             System.out.println("Yes");
            else
              System.out.println("No");
        }
    }
}// } Driver Code Ends


//User function Template for Java

class match
{
    static int d= 256;
    
    static boolean search(String pat, String txt, int q)
    {
            // Your code here
            int m = pat.length(), n = txt.length();
            int h=1;
            for(int i=0;i<m-1;i++)
                h = (h*d) % q;
            // System.out.println("h: "+h);
                
            int p=0, t=0;
            for(int i=0;i<m;i++){
                p = (p*d + pat.charAt(i)) % q;
                t = (t*d + txt.charAt(i)) % q;
                // System.out.println("p: "+p+" t: "+t);
            }

            for(int i=0;i<=n-m;i++){
                if(t == p){
                    boolean flag = true;
                    for(int j=0;j<m;j++){
                        if(txt.charAt(i+j) != pat.charAt(j)){
                            flag = false;
                            break;
                        }
                    }
                    if(flag)
                        return true;
                }
                if(i<n-m){
                    t = (d*(t-txt.charAt(i)*h) + txt.charAt(i+m)) % q;
                    if(t<0)
                        t = t+q;
                    // System.out.println("p: "+p+" t: "+t);
                }
            }
            return false;
    }
}