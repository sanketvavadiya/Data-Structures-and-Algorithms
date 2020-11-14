import java.io.*;
import java.lang.*;
import java.util.*;
class MinimumNumberInSorted
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            long n = Long.parseLong(read.readLine());
            String st[] = read.readLine().trim().split("\\s+");
            
            int arr[] = new int[(int)n];
            
            for(long i = 0; i < n; i++)
              arr[(int)i] = Integer.parseInt(st[(int)i]);
              
            System.out.println(new MinimumNumber().minNumber(arr,0,n-1));
            
        }
    }
    
}

/*This is a function problem.You only need to complete the function given below*/
class MinimumNumber{
    
    static long minNumber(int arr[], long low, long high)
    {
        // Your code here
        int mid=0;
        while(low<high){
            mid=(int)(low+high)/2;
            if(arr[mid]>=arr[(int)high]){
                System.out.println(arr[mid]);
                low=mid+1;
            }
            else if(arr[mid]>arr[(int)low])
                high=mid-1;
            System.out.println(low+" "+mid+" "+high);
        }
        return arr[mid];
    }
}
// int mid = 0;
//         while(low <= high)
//         {
//             mid = (int)(low+high)/2;
//             if(arr[mid] < arr[mid-1])
//                 return arr[mid];
//             if(arr[0] > arr[mid])
//                 high = mid-1;
//             else if(arr[0] < arr[mid])
//                 low = mid+1;
//         }
//         return -1;