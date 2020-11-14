/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class NthPrime {
	static void set(String[]prime)
	{
		prime[0] = "2";
		prime[1] = "3";
		prime[2] = "5";
		prime[3] = "7";

		int ind=4;
		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++) {
				prime[ind++] = prime[i]+prime[j];
			}
		}

		for (int i=4; i<20; i++) {
			for (int j=0; j<4; j++) {
				prime[ind++] = prime[i]+prime[j];
			}
		}

		ind = 84;
		for (int i=4; i<20; i++) {
			prime[ind++] = "22"+prime[i];
		}
	}
	public static void main (String[] args) throws IOException{
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String prime[] = new String[100];
		set(prime);
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0){
			int n = Integer.parseInt(br.readLine());
			System.out.println(prime[n-1]);
		}
	}
}