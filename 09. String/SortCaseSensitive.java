// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;


 // } Driver Code Ends


class solve{
    public static String caseSort(String str) {
        // Your code here
        int lower[] = new int[26];
        int upper[] = new int[26];
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>=97)
                lower[str.charAt(i)-97]++;
            else
                upper[str.charAt(i)-65]++;
        }

        StringBuffer sb = new StringBuffer();
        for (int i=0; i<str.length(); i++) {
            if(str.charAt(i)>=97){
                for(int j=0;j<26;j++){
                    if(lower[j]>0){
                        sb.append((char)(j+97));
                        lower[j]--;
                        break;
                    }
                }
            }
            else{
                for (int j=0; j<26; j++) {
                    if(upper[j]>0){
                        sb.append((char)(j+65));
                        upper[j]--;
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }
}

// { Driver Code Starts.

class SortCaseSensitive {
    
	public static void main (String[] args) {
		
    	try {
    	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	    String[] words = br.readLine().split("\\s+");
    	    int numTestCases = Integer.parseInt(words[0]);
    	    
    	    for (int tIdx = 0; tIdx < numTestCases; tIdx++) {
    	        words = br.readLine().split("\\s+");
    	        int size = Integer.parseInt(words[0]);
    	        String str = br.readLine();
    	        String sortedStr = new solve().caseSort(str);
    	        System.out.println(sortedStr);
    	    }
    	}
    	catch (IOException e) {
    	    System.out.println(e);
    	}
	}
}
  // } Driver Code Ends