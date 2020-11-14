// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class LeftMostRepeating
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String str = sc.next();
            int index = new Repeatation().repeatedCharacter(str);
            if(index == -1)
                System.out.println("-1");
            else
                System.out.println(str.charAt(index));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Repeatation
{
    static int repeatedCharacter(String S)
    {
        // add your code here
        int find[] = new int[256];
        int res = Integer.MAX_VALUE;
        for(int i=0;i<256;i++)
            find[i] = -1;
            
        for(int i=S.length()-1;i>=0;i--){
            if(find[S.charAt(i)]==-1)
                find[S.charAt(i)] = i;
            else
                res = find[S.charAt(i)];
        }
        return res==Integer.MAX_VALUE ? -1 : res;
    }
}