import java.util.ArrayList;
class RabinKarp
{
	private int d;
	private int q;
	String text;
	String patt;
	RabinKarp(String text, String pattern){
		this.text = text;
		patt = pattern;
	}
	
	ArrayList<Integer> findPattern(){
	 	int m = patt.length();
	 	int n = text.length();
	 	int h = 1;
	 	d = 10;
	 	q = 101;
	 	for (int i=0; i<m-1; i++) {
	 		h  = (h*d)%q;
	 	}

	 	int t = 0;
	 	int p = 0;
	 	for (int i=0; i<m; i++) {
	 		t = (d*t + text.charAt(i))%q;
	 		p = (d*p + patt.charAt(i))%q;
	 	}

	 	ArrayList<Integer> res = new ArrayList<Integer>();

	 	for (int i=m; i<=n; i++) {
	 		if(t == p){
	 			int j;
	 			for (j=0; j<m; j++) {
	 				if(text.charAt(i-m+j) != patt.charAt(j))
	 					break;
	 			}
	 			if(j == m)
	 				res.add(i-m);
	 		}
	 		if(i<n){
	 			t = ((d*(t-text.charAt(i-m)*h)) + text.charAt(i))%q;
	 			if(t < 0)
	 				t = t+q;
	 		}
	 	}
	 	return res;
	}
}

class KnuthMorrisPatt extends RabinKarp
{
	private int lps[];
	KnuthMorrisPatt(String text, String patt){
		super(text, patt);
		lps = new int[patt.length()];
	}
	void computeLps(int m){
		lps[0] = 0;
		int len = 0;
		int i=1;
		while(i<m) {
			if(patt.charAt(i) == patt.charAt(len))
				lps[i++] = ++len;
			else{
				if(len == 0)
					lps[i++] = 0;
				else
					len = lps[len-1];
			}
		}
	}

	ArrayList<Integer> findPattern(){
		int m = patt.length();
		int n = text.length();
		computeLps(m);

		ArrayList<Integer> res = new ArrayList<Integer>();
		int j = 0, i = 0;
		while(i<n) {
			if(patt.charAt(j) == text.charAt(i)){
				i++;
				j++;
			}

			if( j == m){
				res.add(i-m);
				j = lps[j-1];
			}			
			else if(i<n && text.charAt(i) != patt.charAt(j)){
				if(j!=0)
					j = lps[j-1];
				else
					i++;
			}
		}
		return res;
	}
}

class StringMatching
{
	public static void main(String[] args) {
		String text = "AABAACAADAABAABA";
		String patt = "AABA";

		// RabinKarp rk = new RabinKarp(text, patt);
		// System.out.println(java.time.LocalTime.now());
		// ArrayList<Integer> indexes = rk.findPattern();
		// System.out.println(java.time.LocalTime.now());
		// printIndexes(indexes);

		KnuthMorrisPatt kmp = new KnuthMorrisPatt(text, patt);
		System.out.println(java.time.LocalTime.now());
		ArrayList<Integer> indexes = kmp.findPattern();
		System.out.println(java.time.LocalTime.now());
		printIndexes(indexes);
	}
	static void printIndexes(ArrayList<Integer> arr){
		for (int i=0; i<arr.size(); i++) {
			System.out.print(arr.get(i)+" ");
		}
		System.out.println();
	}
}