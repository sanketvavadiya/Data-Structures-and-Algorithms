package classFiles;
// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class KMostOccuring {
    
    
    public static void main (String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    inputLine = br.readLine().trim().split(" ");
		    int[] arr = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i]=Integer.parseInt(inputLine[i]);
		    }
		    int k = Integer.parseInt(br.readLine().trim());
		    new solve().kMostOccuring(arr, n, k);
		}
	}
}// } Driver Code Ends


class solve{
    void kMostOccuring(int arr[], int n, int k){
        // your code here
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i=0;i<n;i++){
            if(hm.containsKey(arr[i])){
                hm.put(arr[i], hm.get(arr[i])+1);
            }
            else
                hm.put(arr[i], 1);
        }
        // System.out.println(hm);

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        Iterator it = hm.entrySet().iterator(); 
        while(it.hasNext()){
            Map.Entry mp = (Map.Entry)it.next();
            int i = (int)mp.getValue();
            pq.add(i);
        }
        // System.out.println(pq);
        
        int res = 0;
        for (int i=0; i<k; i++) {
            res += pq.poll();
        }
            
        System.out.print(res);
    }
}