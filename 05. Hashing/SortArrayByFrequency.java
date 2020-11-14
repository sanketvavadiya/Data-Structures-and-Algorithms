// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.Map.Entry;


class SortArrayByFrequency 
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(sc.readLine());
	    while(n != 0)
		{
			int size = Integer.parseInt(sc.readLine());
			int arr[] = new int[size];
			String[] temp = sc.readLine().trim().split("\\s+");
			
			for(int i = 0; i < size; i++)
			    arr[i] = Integer.parseInt(temp[i]);
			    
			    new Sorting().sortByFreq(arr, size);
			    System.out.println();
			n--;
		}
	}
}
// } Driver Code Ends
//User function Template for Java

class Sorting
{
    static void sortByFreq(int arr[], int n)
    {
        // add your code here
        Arrays.sort(arr);
        HashMap<Integer, Integer> order = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();

        for(int i=0;i<n;i++){
        	order.put(arr[i], i);
        	if(freq.containsKey(arr[i]))
        		freq.put(arr[i], freq.get(arr[i])+1);
        	else
        		freq.put(arr[i], 1);
        }

        int matrix[][] = new int[freq.size()][2];
        int j=0;
        for(Map.Entry i : freq.entrySet()){
        	matrix[j][0] = (int)i.getKey();
        	matrix[j][1] = (int)i.getValue();
        	j++;
        }

        Arrays.sort(matrix, new Comparator<int []>(){
        	public int compare(final int [] temp1, final int [] temp2){
        		if(temp1[1] <= temp2[1])
        			return 1;
        		else
        			return -1;
        	}
        });

        for(int i=0;i<matrix.length;i++){
        	for(j=0;j<matrix[i][1];j++)
        		System.out.print(matrix[i][0] + " ");	        		
        }
        System.out.println();
    }
}