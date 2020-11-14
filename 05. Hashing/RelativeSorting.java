/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class RelativeSorting {
	public static void main (String[] args) throws IOException {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while(t-- > 0){
		    String in1[] = br.readLine().trim().split(" ");
		    
		    int n = Integer.parseInt(in1[0]);
		    int m = Integer.parseInt(in1[1]);
		    
		    String in2[] = br.readLine().trim().split(" ");
		    int arr[] = new int[n];
		    for(int i=0;i<n;i++)
		        arr[i] = Integer.parseInt(in2[i]);
		    
		    String in3[] = br.readLine().trim().split(" ");
		    int brr[] = new int[m];
		    for(int i=0;i<m;i++)
		        brr[i] = Integer.parseInt(in3[i]);
		       
		    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		    for(int i=0;i<n;i++){
		        if(hm.containsKey(arr[i]))
		            hm.put(arr[i], hm.get(arr[i])+1);
		        else
		            hm.put(arr[i], 1);
		    }
		    
		    for(int i=0;i<m;i++){
		        if(hm.containsKey(brr[i])){
		            for(int j=0;j<hm.get(brr[i]);j++)
		                System.out.print(brr[i]+" ");
		            hm.remove(brr[i]);
		        }
		    }
		    
		    // System.out.println(hm);
		    int temp [] = new int[hm.size()];
		    for(Map.Entry i : hm.entrySet()){
		        int val = (int)i.getValue();
		        for(int j=0;j<val;j++){
		            temp[j] = (int)i.getKey();
		            System.out.print(temp[j] + " ");
		        }
		    }
		    // // Arrays.sort(temp);
		    // for(int i=0;i<temp.length;i++)
		    //     System.out.print(temp[i] + " ");
		}
	}
}