/* 
	given k sorted array merge them
	Time colexity: O(n*k (logk))
	Auxiliary space: O(k)
*/
package classFiles;
import java.util.*;
class MinHeap implements Comparable<MinHeap>{
	int val;
	int arrPos;
	int elePos;
	MinHeap(int val, int arrPos, int elePos){
		this.val = val;
		this.arrPos = arrPos;
		this.elePos = elePos;
	}

	@Override
	public int compareTo(MinHeap mh){
		return this.val-mh.val;
	}

	@Override
	public String toString(){
		return val+" "+arrPos+" "+elePos;
	}
}

class Helper{
	void sort(int arr[][], int k){
		PriorityQueue<MinHeap> pq = new PriorityQueue<MinHeap>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i=0; i<k; i++) {
			pq.add(new MinHeap(arr[i][0], i, 0));
		}
		// System.out.println(pq.toString());
		while(!pq.isEmpty()){
			MinHeap curr = pq.poll();
			res.add(curr.val);
			int arrPos = curr.arrPos, elePos = curr.elePos+1;
			if(elePos<arr[arrPos].length){
				pq.add(new MinHeap(arr[arrPos][elePos], arrPos, elePos));
			}
		}
		System.out.println(res);
	}
}

class MergeKSortedArray{
	public static void main(String[] args) {
		int k = 3;
		int arr[][] = {{10, 20}, {5, 15}, {6, 8, 9}};
		new Helper().sort(arr, k);
	}
}