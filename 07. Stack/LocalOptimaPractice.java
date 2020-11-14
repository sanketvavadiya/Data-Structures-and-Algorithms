import java.util.*;

public class LocalOptimaPractice{
	public static void main(String[] args) {
		int n = 8;
		int arr[] = {15, 10, 18, 12, 4, 6, 2, 8};

		int nextLarger1[] = getNextLarger1(arr);		// 18, 18, -1, -1, 6, 8, 8, -1
		int nextLarger2[] = getNextLarger2(arr);		// 18, 18, -1, -1, 6, 8, 8, -1
		int prevLarger[] = getPrevLarger(arr);			// -1, 15, -1, 18, 12, 12, 6, 12
		int nextSmaller1[] = getNextSmaller1(arr);		// 10, 4, 12, 4, 2, 2, -1, -1 
		int nextSmaller2[] = getNextSmaller2(arr);		// 10, 4, 12, 4, 2, 2, -1, -1 
		int prevSmaller[] = getPrevSmaller(arr);		// -1, -1, 10, 10, -1, 4, -1, 2

		printArr(nextLarger1);
		printArr(nextLarger2);
		printArr(prevLarger);
		printArr(nextSmaller1);
		printArr(nextSmaller2);
		printArr(prevSmaller);
	}

	static void printArr(int arr[])
	{
		for(int i=0; i<arr.length; i++) System.out.print(arr[i] + " ");
		System.out.println();
	}

	static int[] getNextLarger1(int arr[])
	{
		Stack<Integer> s = new Stack<Integer>();
		int res[] = new int[arr.length];
		s.push(arr.length-1);
		res[arr.length-1] = -1;
		for(int i=arr.length-2;i>=0;i--){
			while(!s.empty() && arr[s.peek()]<=arr[i])
				s.pop();
			res[i] = s.empty() ? -1 : arr[s.peek()];
			s.push(i); 
		}
		return res;
	}

	static int[] getNextLarger2(int arr[])
	{
		Stack<Integer> s = new Stack<Integer>();
		int res[] = new int[arr.length];
		for (int i=0; i<arr.length; i++) {
			res[i] = -1;
			while(!s.empty() && arr[s.peek()] < arr[i])
				res[s.pop()] = arr[i];
			s.push(i);
		}
		return res;
	}

	static int[] getPrevLarger(int arr[])
	{
		Stack<Integer> s = new Stack<Integer>();
		int []res = new int[arr.length];
		s.push(0);
		res[0] = -1;
		for (int i=1; i<arr.length; i++) {
			while(!s.empty() && arr[s.peek()]<=arr[i])
				s.pop();
			res[i] = s.empty() ? -1 : arr[s.peek()];
			s.push(i);
		}
		return res;
	}

	static int[] getNextSmaller1(int arr[])
	{
		Stack<Integer> s = new Stack<Integer>();
		int res[] = new int[arr.length];
		res[arr.length-1] = -1;
		s.push(arr.length-1);
		for (int i=arr.length-2; i>=0; i--) {
			while(!s.empty() && arr[s.peek()]>=arr[i])
				s.pop();
			res[i] = s.empty() ? -1 : arr[s.peek()];
			s.push(i);
		}
		return res;
	}

	static int[] getNextSmaller2(int arr[])
	{
		Stack<Integer> s = new Stack<Integer>();
		int res[] = new int[arr.length];
		for (int i=0; i<arr.length; i++) {
			res[i] = -1;
			while(!s.empty() && arr[s.peek()] > arr[i])
				res[s.pop()] = arr[i];
			s.push(i);
		}
		return res;
	}

	static int[] getPrevSmaller(int arr[])
	{
		Stack<Integer> s = new Stack<Integer>();
		int res[] = new int[arr.length];
		s.push(0);
		res[0] = -1;
		for (int i=1; i<arr.length; i++) {
			while(!s.empty() && arr[s.peek()]>=arr[i])
				s.pop();
			res[i] = s.empty() ? -1 : arr[s.peek()];
			s.push(i);
		}
		return res;
	}
}