/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class LongestSubstringWithoutRepeatingChar {
    static int method(String s){
        int n = s.length(), max=0;
        for(int i=0;i<n;i++){
            boolean count[] = new boolean[256];
            int j, curr=0;
            for(j=i;j<n;j++){
                if(count[s.charAt(j)] == true){
                    break;
                }
                else{
                    count[s.charAt(j)] = true;
                    curr++;
                }
            }
            max = max < curr ? curr : max;
        }
        return max;
    }
	public static void main (String[] args) throws IOException {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0){
		    String s = br.readLine();
		    System.out.println(method(s));
		}
	}
}