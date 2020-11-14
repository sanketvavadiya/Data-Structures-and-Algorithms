// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class SumOfNumberInString {
	public static void main (String[] args) throws IOException{
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    int t=Integer.parseInt(st.nextToken());
	    while(t-->0){
	        String s=br.readLine();
	        
	        SumNumbers obj = new SumNumbers();
	        
	        System.out.println(obj.findSum(s));
	    }
		
	}
}
// } Driver Code Ends



class SumNumbers{
    // Function to find the sum of all
    // the numbers in the given string s
    public static long findSum(String s){
        
        // your code here
        int res=0, curr=0;
        for(int i=0;i<s.length();i++){
        	if(i==0 && s.charAt(i)>=49 && s.charAt(i)<=57){
        		curr = (int)s.charAt(i)-48;
        		res += curr;
        	}
        	else{
        		if(s.charAt(i)>=48 && s.charAt(i)<=57){
        			if(s.charAt(i-1)>=49 && s.charAt(i-1)<=57){
        				res -= curr;
        				curr = curr*10;
        				curr += (int)s.charAt(i)-48;
        			}
        			else{
        				curr = (int)s.charAt(i)-48;
        			}
        			res += curr;
        			// System.out.println(curr);
        		}
        	}
        }
        return res;
    }
    
}