import java.io.*;
import java.util.*; 	
class Temp_mean_median 
{
	public static void main (String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		while(T-->0)
		{
		    MM obj=new MM();
		    int N;
		    N=sc.nextInt();
		    int a[]=new int [N];
		    for(int i=0;i<N;i++)
		    {
		        int x=sc.nextInt();
		        a[i]=x;
		    }
		    
		    
		    System.out.println(obj.mean(a,N)+" "+obj.median(a,N));
		   
		    
		}
		
	}
}
/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
class MM
{
    
  public int median(int A[],int N)
    {
      
       Arrays.sort(A);
       
       //Your code here
       if(N % 2 == 0)
        return (int)(A[N/2] + A[N/2 - 1])/2;
       else
        return (int)A[N/2];
       //If median is fraction then conver it to integer and return
    }
    
    public int mean(int A[],int N)
    {
       //Your code here
       long sum = 0;
       for(int i=0;i<N;i++)
            sum += A[i];
       return (int)sum/N;
    }
}
