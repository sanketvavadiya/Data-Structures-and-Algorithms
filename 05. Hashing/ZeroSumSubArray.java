/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class ZeroSumSubArray {
	public static void main (String[] args) throws IOException {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0){
		    int n = Integer.parseInt(br.readLine());
		    int arr[] = new int[n];
		    
		  //  String in[] = br.readLine().trim().split(" ");
		    String in[] = br.readLine().trim().split(" ");
		    for(int i=0;i<n;i++)
		        arr[i] = Integer.parseInt(in[i]);
		        
		    HashMap <Integer, Integer> hm = new HashMap<Integer, Integer>();
		    hm.put(0, 1);
		    int count=0, pre_sum=0;
		    for(int i=0;i<n;i++){
		        pre_sum += arr[i];
		        if(hm.containsKey(pre_sum)){
		            count += hm.get(pre_sum);
		            hm.put(pre_sum, hm.get(pre_sum)+1);
		        }
		        else
		            hm.put(pre_sum, 1);
		    }
		    System.out.println(count);
		}
	}
}