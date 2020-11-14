// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;


 // } Driver Code Ends


class solve{
    public static void solution(String str, String patt){
        // Your code here
        // HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>(); 
        for (int i=0; i<str.length(); i++) {
        	if(!hm.containsKey(str.charAt(i)))
        		hm.put(str.charAt(i), i);
        }

        int min = Integer.MAX_VALUE;
        char ans='a';
        for (int i=0; i<patt.length(); i++) {
        	if(hm.containsKey(patt.charAt(i)) && min>hm.get(patt.charAt(i))){
        		min = hm.get(patt.charAt(i));
        		ans = patt.charAt(i);
        	}
        }

        if(min == Integer.MAX_VALUE)
        	System.out.print("No character present");
        else
        	System.out.print(ans);
    }
}

// { Driver Code Starts.

class MinimumIndexedChar {
	public static void main (String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0)
		{
		    t--;
		    
		    String s1=sc.next();
		    String s2=sc.next();
		    
		    new solve().solution(s1, s2);
		    System.out.println();
		}
	}
}
  // } Driver Code Ends