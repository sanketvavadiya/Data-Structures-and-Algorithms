/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class CheckIfTwoArraysEqual {
	public static void main (String[] args) throws IOException {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0)
		{
		   	int n = Integer.parseInt(br.readLine());
		    
		    HashMap <Long, Integer> hm1 = new HashMap<Long, Integer>();

		    String in1[] = br.readLine().trim().split(" ");
		    for(int i=0;i<n;i++){
		        long data = Long.parseLong(in1[i]);
		        if(hm1.containsKey(data)){
		            int val = hm1.get(data);
		            hm1.replace(data, val+1);
		        }
		        else
		            hm1.put(data, 1);
		    }
		    
		    HashMap <Long, Integer> hm2 = new HashMap<Long, Integer>();

		   String in2[] = br.readLine().trim().split(" ");
		    for(int i=0;i<n;i++){
		        long data = Long.parseLong(in2[i]);
		        if(hm2.containsKey(data)){
		            int val = hm2.get(data);
		            hm2.replace(data, val+1);
		        }
		        else
		            hm2.put(data, 1);
		    }
		    
		    boolean flag=true;
		    for(Map.Entry<Long, Integer> e : hm1.entrySet()){
		        long key1=e.getKey();
		        int val1=e.getValue();
		        if(!(hm2.containsKey(key1) && val1==hm2.get(key1))){
		            flag=false;
		            break;
		        }
		    }
		    if(flag)
		        System.out.println(1);
		    else
		        System.out.println(0);
		}
	}
}