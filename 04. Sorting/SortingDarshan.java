import java.io.*;
import java.lang.*;
import java.util.*;

public class Sorting{
	public static void main(String args[]) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int n = Integer.parseInt(br.readLine());
      
      String str[] = br.readLine().trim().split(" ");

      //Sample Input
      // 6
	  // 5 10 2 3 14 5

      
      int arr[] = new int[n];
      for(int i=0; i<n; i++)
      {
          arr[i] = Integer.parseInt(str[i]);
      }
      
      bubbleSort(arr);
      // selectionSort(arr);
      // insertionSort(arr);
      // mergeSort(arr, 0, arr.length-1);
      // quickSort(arr, 0, arr.length-1);
      // countingSort(arr, 1, 100);
      // heapSort(arr);

      
      for(int i=0; i<n; i++) System.out.print(arr[i] + " ");
	}

	static void bubbleSort(int arr[])
    {
    	// stable, In-place
    	// O(nE2), O(1)
        for(int i=0; i<arr.length; i++)
        {
            for(int j=0; j<arr.length-i-1; j++)
            {
                if(arr[j] > arr[j+1])
                {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    static void selection(int arr[])
    {
    	// Not stable, In-place
    	// O(nE2), O(1)
        for(int i=0; i<arr.length-1; i++)
        {
            int min = i;
            for(int j=i+1; j<arr.length; j++)
            {
                if(arr[min] > arr[j])
                {
                    int tmp = arr[min];
                    arr[min] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

	static void insertionSort(int arr[])
    {
    	// stable, In-place
    	// O(nE2), O(1)
        for(int i=1; i<arr.length; i++)
        {
            int j=i-1;
            int key = arr[i];
            for(; j>=0 && arr[j] > key; j--)
            {
                arr[j+1] = arr[j];
            }
            arr[j+1] = key;
        }
    }

	static void mergeSort(int arr[], int l, int h)
    {
    	// stable, Not In-place
    	// O(nLogn), O(n)
        if(l<h)													// O(logn)
        {
            int mid = (l+h) >>> 1;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, h);
            merge(arr, l, mid, h);
        }
    }
    
    static void merge(int arr[], int l, int mid, int h)			// O(n)
    {
        int n1 = mid - l + 1;
        int n2 = h - mid;
        
        int arr1[] = new int[n1+1];
        int arr2[] = new int[n2+1];
        
        arr1[n1] = Integer.MAX_VALUE;
        arr2[n2] = Integer.MAX_VALUE;
        
        for(int i=0; i<n1; i++) arr1[i] = arr[l+i];
        for(int j=0; j<n2; j++) arr2[j] = arr[mid+1+j];
        
        int i=0;
        int j=0;
        int k;
        for(k=l; i<n1 && j<n2; k++)
        {
            if(arr1[i] <= arr2[j]) arr[k] = arr1[i++];
            else arr[k] = arr2[j++];
        }
        
        while(i < n1) arr[k++] = arr1[i++];
        while(j < n2) arr[k++] = arr2[j++];
    }

	static void quickSort(int arr[], int l, int h)
    {
    	// not stable, In-place
    	// Avg O(nLogn) Worst O(nE2), O(1)
        if(l<h)
        {
            int p = partition(arr, l, h);
            
            quickSort(arr, l, p-1);
            quickSort(arr, p+1, h);
        }
    }
    
    static int partition(int arr[], int l, int h)
    {
        int pivot = arr[h];
        
        int i=l-1;
        
        for(int j=l; j<h; j++)
        {
            if(arr[j] < pivot)
            {
                i++;
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }
        
        int tmp = arr[i+1];
        arr[i+1] = arr[h];
        arr[h] = tmp;
        
        return i+1;
    }

	static void countingSort(int arr[], int l, int h)
    {
    	// stable, not In-place
    	// O(n+rangeOfNums), O(n+rangeOfnums)
    	// Inefficient when n<<rangeOfNums
        int freq[] = new int[h-l+1];
        
        for(int i=0; i<arr.length; i++)
        {
            freq[arr[i] - l]++;
        }
        int i=0;
        for(int j=0; j<h-l+1; j++)
        {
            while(freq[j]-- > 0) arr[i++] = j+l;
        }
    }

	static void radixSort(int arr[])
	{

	}

	static void heapSort(int arr[])
    {
    	// not stable, In-place
    	// O(nLogn), O(1)
        int n = arr.length;
        //Build Maxheap 							//	O(n)
        for(int i=n/2-1; i>=0; i--) heapify(arr, n, i);
        
        //bringing last to the top
        for(int i=n-1; i>0; i--)
        {
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            
            heapify(arr, i, 0);
        }
    }
    
    static void heapify(int arr[], int n, int i)	// O(logn)
    {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;
        
        if(left<n && arr[left]>arr[largest]) largest = left;
        if(right<n && arr[right]>arr[largest]) largest = right;
        
        if(largest != i)
        {
            int tmp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = tmp;
            
            heapify(arr, n, largest);
        }
    }
}