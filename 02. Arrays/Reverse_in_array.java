import java.io.*;
import java.util.*;
//Position this line where user code will be pasted.
class Reverse_in_array 
{    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine1[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine1[0]);
		    int k = Integer.parseInt(inputLine1[1]);
		    
		    ArrayList<Integer> mv = new ArrayList<>();
		    
		    String inputLine2[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        mv.add(Integer.parseInt(inputLine2[i]));
		    }
		    
		    Reverse obj = new Reverse();
		    
		    mv = obj.reverseInGroups(mv, n, k);
		    
		    StringBuffer str = new StringBuffer();
		    
		    for(int i=0; i<n; i++){
		        str.append(mv.get(i) + " ");
		    }
		    System.out.println(str);
		}
	}
}


/*This is a function problem.You only need to complete the function given below*/
class Reverse{
    
    // Function to reverse array in group of k 
    public static ArrayList<Integer> reverseInGroups(ArrayList<Integer> mv, int n, int k) {
        // add your code here
        int i = k-1, remain = n;
        while(true)
        {
        	if(remain >= k)
        	{
        		int index = i-k+1;
        		for(int j=i;j>index;j--, index++)
        			Collections.swap(mv, j, index);
        		i += k;
        		remain -= k;
        	}
        	else
        	{
        		i = i - k > 0 ? i-k+1 : 0;
        		for(int j=n-1;j>=i;i++, j--)
        			Collections.swap(mv, i, j);
        		break;
        	}
        }
        return mv;
	}
}
