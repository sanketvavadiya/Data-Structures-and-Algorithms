import java.util.*;
import java.lang.*;
import java.io.*;
class FlorrInArray
{
    public static void main (String[] args)throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
           String a[] = read.readLine().trim().split("\\s+");
           int n = Integer.parseInt(a[0]);
           long x = Long.parseLong(a[(int)1]);
           String st[] = read.readLine().trim().split("\\s+");
        
           long arr[] = new long[n];
           for(int i = 0; i < n; i++)
           {
               arr[i] = Long.parseLong(st[i]);
           }
           
           System.out.println(new FloorSearch().findFloor(arr, 0, n-1, x));
          
        }
    }
    
}

/*This is a function problem.You only need to complete the function given below*/
class FloorSearch{
    
    // Function to find floor of x
    // arr: input array
    // left and right as 0 and n-1, where n is the size of array
    static int findFloor(long arr[], int l, int r, long x)
    {
        if(l==r)
          return arr[l] < x ? l : -1;
        int ans=-1, mid=0;
        while(l <= r)
        {
          mid = (l+r)/2;
          if(arr[mid] == x)
            return mid;
          else if(arr[mid] > x)
            r = mid - 1;
          else
            l = mid + 1;
        }
        return arr[mid] > x ? mid - 1 : mid;
    }    
}