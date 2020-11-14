// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class LeftMostNonRepeating
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            
            char ans=new Repeatation().nonrepeatingCharacter(st);
            
            if(ans!='$')
            System.out.println(ans);
            else
            System.out.println(-1);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Repeatation
{
    static char nonrepeatingCharacter(String S)
    {
        //Your code here
        int foccur[] = new int[256];

        for (int i=0; i<256; i++) {
        	foccur[i] = -1;
        }

        for (int i=0; i<S.length(); i++) {
        	if(foccur[S.charAt(i)] == -1)
        		foccur[S.charAt(i)] = i;
        	else
        		foccur[S.charAt(i)] = -2;
        }

        int res = Integer.MAX_VALUE;
        for(int i=0;i<256;i++){
        	if(foccur[i]>=0){
        		res = res<foccur[i] ? res : foccur[i];
        	}
        }
        if(res==Integer.MAX_VALUE)
        	return '$';
        return S.charAt(res);
    }
}