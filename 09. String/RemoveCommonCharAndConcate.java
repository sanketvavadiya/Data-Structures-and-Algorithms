// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class RemoveCommonCharAndConcate{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        
        while(t--!=0){
            String s1=in.next(),
                   s2=in.next();
            
            RemoveCommon obj = new RemoveCommon();
            
            System.out.println(obj.concatenatedString(s1,s2));
        }
    }
}
// } Driver Code Ends



class RemoveCommon{
    
    // Function which concatenate two strings
    // after removing common characters
    public static String concatenatedString(String s1,String s2){
        
        // Your code here
        boolean counts1[] = new boolean[256];
        for (int i=0; i<s1.length(); i++) {
            counts1[s1.charAt(i)] = true;
        }

        boolean counts2[] = new boolean[256];
        for (int i=0; i<s2.length(); i++) {
            counts2[s2.charAt(i)] = true;
        }

        StringBuffer sb = new StringBuffer();
        for (int i=0; i<s1.length(); i++) {
            if(counts1[s1.charAt(i)] && (!counts2[s1.charAt(i)]))
                sb.append(s1.charAt(i));
        }

        for (int i=0; i<s2.length(); i++) {
            if(counts2[s2.charAt(i)] && (!counts1[s2.charAt(i)]))
                sb.append(s2.charAt(i));
        }
        // System.out.println(sb);
        return sb.toString();
    }
}
