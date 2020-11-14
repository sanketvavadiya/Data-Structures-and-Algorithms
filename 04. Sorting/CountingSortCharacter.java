import java.util.*;
import java.lang.*;

class CountingSortCharacter
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            char seq[] = new char[(int)n+1];
            String str = "";
            str = sc.next();
            seq = str.toCharArray();
            GfG gfg = new GfG();
             gfg.countSort(seq);
            System.out.println(seq);
        }
    }
}
// } Driver Code Ends
class GfG
{
    
    // Function to do count sort
    // seq[]: input array
    public static void countSort(char seq[])
    {
        // add your code here 
        int n = seq.length; 
        int count[] = new int[26];
		for(int i=0;i<26;i++)
			count[i] = 0;
		for(int i=0;i<n;i++)
			count[(int)seq[i]-97]++;
		for(int i=1;i<26;i++)
			count[i] = count[i] + count[i-1];
		
		char temp[] = new char[n];
		for(int i=n-1;i>=0;i--)
		{
			temp[count[(int)seq[i]-97] -1] = seq[i];
			count[(int)seq[i]-97]--;
		}
		for(int i = 0;i<n;i++)
			seq[i] = temp[i];
    }
}