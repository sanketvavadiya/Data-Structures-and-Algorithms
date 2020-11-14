// { Driver Code Starts
import java.util.*;


class CelebrityProblem
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int N = sc.nextInt();
			int M[][] = new int[N][N];
			for(int i=0; i<N; i++)
			{
				for(int j=0; j<N; j++)
				{
					M[i][j] = sc.nextInt();
				}
			}
		System.out.println(new Celebrity().getId(M,N));
		t--;
		}
	}
}
// } Driver Code Ends


class Celebrity
{
    // The task is to complete this function
    int getId(int M[][], int n)
    {
        // Your code here
        boolean celebrity[] = new boolean[n];
        for (int i=0; i<n; i++) {
        	celebrity[i] = true;
        }

        int totalCeleb = 0;
        for (int i=0; i<n; i++) {
        	for (int j=0; j<n; j++) {
        		if(i==j)
        			continue;
        		if(M[i][j] == 0){
        			celebrity[j] = false;
        		}
        		if(M[i][j] == 1){
        			celebrity[i] = false;
        		}
        	}
        	// System.out.println("i:"+i);
        	for (int k=0; k<n; k++) {
        		// System.out.println("k: "+k+" "+celebrity[k]);
        	}
        }
        int res = -1;
        for (int i=0; i<n; i++) {
        	if(celebrity[i]){
        		res = i;
        		totalCeleb++;
        	}
        }
        return totalCeleb==1 ? res : -1;
    }
}
