/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class KeyPadTyping {
	static int method(char c)
	{
		if((c>=65 && c<=67) || c>=97 && c<=99)
			return 2;

		if((c>=68 && c<=70) || c>=100 && c<=102)
			return 3;

		if((c>=71 && c<=73) || c>=103 && c<=105)
			return 4;

		if((c>=74 && c<=76) || c>=106 && c<=108)
			return 5;

		if((c>=77 && c<=79) || c>=109 && c<=111)
			return 6;

		if((c>=80 && c<=83) || c>=112 && c<=115)
			return 7;

		if((c>=84 && c<=86) || c>=116 && c<=118)
			return 8;

		if((c>=87 && c<=90) || c>=119 && c<=122)
			return 9;

		else
			return -1;
	}
	public static void main (String[] args) throws IOException{
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
			String in = br.readLine();
			for(int i=0;i<in.length();i++){
				System.out.print(method(in.charAt(i)));
			}
			System.out.println();
		}
	}
}