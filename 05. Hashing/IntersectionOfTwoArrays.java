/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class IntersectionOfTwoArrays {    
	public static void main (String[] args) {
		//code
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    int n=sc.nextInt();
		    int m=sc.nextInt();

		    int a[]=new int[n];
		    HashSet <Integer> hs = new HashSet<Integer>();

		    for(int i=0;i<n;i++){
		        a[i] = sc.nextInt();		   
		        hs.add(a[i]);
		    }


		    int ans = 0;

		    for(int i=0;i<m;i++){
		        int data = sc.nextInt();
		        if(hs.contains(data)){
		        	ans++;
		        	hs.remove(data);
		        }
		    }
		    System.out.println(ans);
		}
	}
}