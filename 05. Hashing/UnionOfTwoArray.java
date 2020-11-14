/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class UnionOfTwoArray {    
	public static void main (String[] args) {
		//code
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    int n=sc.nextInt();
		    int m=sc.nextInt();

		    int a[]=new int[n];
		    int b[]=new int[m];

		    int max = 0, low=0;

		    for(int i=0;i<n;i++){
		        a[i] = sc.nextInt();
		        max=max<a[i]?a[i]:max;
		        low=low>a[i]?a[i]:low;
		    }

		    for(int i=0;i<m;i++){
		    	b[i] = sc.nextInt();
		        max=max<b[i]?b[i]:max;
		        low=low>b[i]?b[i]:low;
		    }

		    ArrayList <Integer> hash1 = new ArrayList<Integer>(max+1);
		    int []hash=new int[max+1];

		    for(int i=low;i<=max;i++)
		    	hash[i]=0;
		    	// hash.add(i, 0);

		    for(int i=0;i<n;i++)
		    	hash[a[i]]++;
		    	// hash.set(a[i], hash.get(i)++);

		    for(int i=0;i<m;i++)
		    	hash[b[i]]++;
		    	// hash.set(b[i], hash.get(i)++);	

		    int count=0;
		    for(int i=low;i<=max;i++)
		    	if(hash[i]!=0)
		    		count++;

		    System.out.print(count);
		}
	}
}