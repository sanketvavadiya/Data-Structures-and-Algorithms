/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Temp_kth_bit {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t != 0)
		{
			int n = sc.nextInt();
			int k = sc.nextInt();
			method(n, k);
			t--;
		}
	}
	public static void method(int n, int k)
	{
		n = n >> k;
		if((n & 1) == 1)
			return true;
		else
			return false;
	}
}