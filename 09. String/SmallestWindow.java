// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class SmallestWindow {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new solve().smallestWindow(s, t));
		    test--;
		}
	}
}// } Driver Code Ends


class solve
{
    // return the smallest window in S with all the characters of P
    // if no such window exists, return "-1" 
    public static String smallestWindow(String S, String P){
        // Your code here
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        boolean count[] = new boolean[256];
        int min=0, max=0;
        for (int i=0; i<P.length(); i++) 
        {
            for(int j=0;j<S.length();j++)
            {
                if (S.indexOf(P.charAt(i))>=0) 
                {
                    if(!hm.containsKey(P.charAt(i)))
                    {
                        hm.put(P.charAt(i), S.indexOf(P.charAt(i)));
                        min = min<S.indexOf(P.charAt(i)) ? S.indexOf(P.charAt(i)) : min;
                        max = max<S.indexOf(P.charAt(i)) ? S.indexOf(P.charAt(i)) : max;
                        System.out.println("min: "+min+" max: "+max);
                    }
                    // System.out.println("occurence of: "+P.charAt(j));
                    count[P.charAt(i)]++;
                }
                else
                {
                    return "-1";
                }
            }   
        }

        System.out.println("min: "+min+" max: "+max);
        System.out.println("min char: "+count[S.charAt(min)]);
        if(count[S.charAt(min)]>1){
            int len = max-min;
            for (int i=min+1; i<S.length(); i++) {
                if(S.charAt(i) == S.charAt(min) && Math.abs(max-i)<len){
                    min = i;
                    // System.out.println("min: "+min+" max: "+max);
                }
            }
        }

        if(count[S.charAt(max)]>1){
            int len = max-min;
            for (int i=max-1; i>=0; i--) {
                if(S.charAt(i) == S.charAt(max) && Math.abs(i-min)<len){
                    max = i;
                }
            }
        }

        String s = "";
        for (int i=min; i<=max; i++) {
            System.out.print(S.charAt(i));
            s += S.charAt(i);
        }
        // System.out.println();
        return s;
    }
}