/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class PositiveNegativePair {
	public static void main (String[] args) throws IOException {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0){
		    int n = Integer.parseInt(br.readLine());
		    
		    int [] arr = new int[n];
		    String []in = br.readLine().trim().split(" ");
		    
		    HashSet <Integer> hs1 = new HashSet<Integer>();
		    HashSet <Integer> hs2 = new HashSet<Integer>();
		    for(int i=0;i<n;i++){
		        int data = Integer.parseInt(in[i]);
		        if(data < 0)
		            hs1.add(Math.abs(data));
		        else
		            hs2.add(data);
		    }
		    
		    n = hs1.size() > hs2.size() ? hs2.size() : hs1.size();
		    Iterator <Integer> i;
		    ArrayList <Integer> temp = new ArrayList<Integer>();
		    
		    if(n == hs1.size()){
		    	i = hs1.iterator();
		    	while(i.hasNext()){
		    		int curr = Math.abs(i.next());
		    		if(hs2.contains(curr))
		    			temp.add(curr);
		    	}
		    }

		    else{
		    	i = hs2.iterator();
		    	while(i.hasNext()){
		    		int curr = Math.abs(i.next());
		    		if(hs1.contains(curr))
		    			temp.add(curr);
		    	}
		    }

		    Collections.sort(temp);
		    StringBuffer sb = new StringBuffer();
		    for(int j=0;j<temp.size();j++){
		        sb.append(temp.get(j) + " ");
		        sb.append((-1 * temp.get(j)) + " ");
		    }
		    System.out.println(sb);
		}
	}
}