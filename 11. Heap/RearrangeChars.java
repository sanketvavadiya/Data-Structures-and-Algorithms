package classFiles;
// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class RearrangeChars {
	public static void main (String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
			while (t-- > 0) {
				String str = br.readLine();
				boolean result = new solve().rearrangeCharacters(str);
				if (result)
					System.out.println(1);
				else
					System.out.println(0);
			}
		} catch (Exception e) {

		}
	}
}
// } Driver Code Ends

class MaxHeap implements Comparable<MaxHeap>{
	int freq;
	char c;
	MaxHeap(int occ, char c){
		freq = occ;
		this.c = c;
	}

	@Override
	public int compareTo(MaxHeap obj){
		return obj.freq-this.freq;
	}

	@Override
	public String toString(){
		return c+"= "+freq;
	}
}
class solve{
    static boolean rearrangeCharacters(String str) {
		// Your code here
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

    	for (int i=0; i<str.length(); i++) {
    		if(hm.containsKey(str.charAt(i)))
    			hm.put(str.charAt(i), hm.get(str.charAt(i))+1);
    		else
    			hm.put(str.charAt(i), 1);
    	}
    	System.out.println(hm);

    	PriorityQueue<MaxHeap> pq = new PriorityQueue<MaxHeap>(Collections.reverseOrder());
    	Iterator it = hm.entrySet().iterator();
    	while(it.hasNext()){
    		Map.Entry mp = (Map.Entry)it.next();
    		pq.add(new MaxHeap((int)mp.getKey(), (char)mp.getValue()));
    	}
    	System.out.println(pq.toString());

    	
    	return true;
	}
}