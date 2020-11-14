package classFiles;
import java.io.*;
import java.util.*;

class MoreThanNbyK {
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    int[] arr = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i] = sc.nextInt();
		    }
		    int k = sc.nextInt();
		    
		    System.out.println(new CountElement().countOccurence(arr, n,  k));
		}
	}
}
// } Driver Code Ends
class CountElement {    
    
    // Function to find element with count more than n/k times
    // arr: input array
    public int countOccurence(int[] arr, int n, int k)
    {
        //your code here,return the answer
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i=0;i<n;i++){
            if(hm.containsKey(arr[i]))
                hm.put(arr[i], hm.get(arr[i])+1);
            else
                hm.put(arr[i], 1);
        }
        
        System.out.println(hm);      
        int res = 0;
        Iterator it = hm.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry mp = (Map.Entry)it.next();
            int i = (int)mp.getValue();
            if(i>n/k)
                res++;
        }
        return res;
    }
}
