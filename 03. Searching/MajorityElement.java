//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;
class MajorityElement
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Majority().majorityElement(arr, n)); 
        }
    }
}

/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
class Majority
{
    static int majorityElement(int arr[], int n)
    {
        // your code here
        int curr_count = 0, curr = 0, count = 0, element = 0;
        for(int i=0;i<n;i++)
        {
            curr = arr[i];
            curr_count = 0;
            for(int j = 0;j<n;j++)
                if(curr == arr[j])
                    curr_count++;
            if(curr_count > count)
            {
                count =  curr_count;
                element = curr;
            }
        }
        return count > (n/2) ? element : -1;
    }
}