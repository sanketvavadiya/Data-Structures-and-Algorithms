// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class MaximumRectangularHistogram {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new solve().getMaxArea(arr, n));
		}
	}
}



// } Driver Code Ends


class solve{
    
    // Function to calculate max rectangular area histogram
    // hist[]: input array
    // n: size of array
    public static long getMaxArea(long hist[], long n)  {
        // your code here
        int ps[] = new int[(int)n];
        int ns[] = new int[(int)n];
        calps(ps, hist);
        calns(ns, hist);
        long res = 0;
	    for(int i=0;i<n;i++){
	    	// System.out.print("arr[i]: "+hist[i]);
	        long curr = hist[i];
	        curr += (i-ps[i]-1)*hist[i];
	        // System.out.print(" curr1: "+curr);
	        curr += (ns[i]-i-1)*hist[i];
	        // System.out.println(" curr2: "+curr);
	        res = res<curr ? curr : res;
	    }
	    return res;
    }
    
    static void calps(int ps[], long hist[]){
    	Stack<Integer> s = new Stack<Integer>();
    	s.push(0);
    	ps[0] = -1;
    	for(int i=1;i<hist.length;i++){
    		while(!s.empty() && hist[s.peek()]>=hist[i]){
    			s.pop();
    		}
    		ps[i] = s.empty() ? -1 :s.peek();
    		s.push(i);
    	}

    	// for(int i=0;i<ps.length;i++){
    	// 	System.out.print(ps[i]+" ");
    	// }
    	// System.out.println();
    } 

    static void calns(int ns[], long hist[]) {
    	Stack<Integer> s = new Stack<Integer>();
    	s.push(hist.length-1);
    	ns[hist.length-1] = hist.length;
    	for (int i=hist.length-2; i>=0; i--) {
    		while (!s.empty() && hist[s.peek()]>=	hist[i]) {
    			s.pop();
    		}
    		ns[i] = s.empty() ? hist.length : s.peek();
    		s.push(i);
    	}

    	// for(int i=0;i<ns.length;i++){
    	// 	System.out.print(ns[i]+" ");
    	// }
    }
}



