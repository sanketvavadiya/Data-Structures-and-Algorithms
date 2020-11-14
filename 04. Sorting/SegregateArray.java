/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class SegregateArray {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i=0;i<n;i++)
		        arr[i] = sc.nextInt();
		    
		    int e = -1, o = n;
		    while(true)
		    {
		    	do{
		    		e++;
		    	}while(arr[e] % 2 == 0);

		    	do{
		    		o--;
		    	}while(arr[o] % 2 != 0);

		    	if(e >= o)
		    		break;

		    	int temp = arr[e];
		    	arr[e] =arr[o];
		    	arr[o] = temp;
		    }
		    
		    StringBuffer sb = new StringBuffer();
		    for(int i=0;i<n;i++)
		        sb.append(arr[i] + " ");
		    
		    System.out.println(sb);
		}
	}
}