class Heapify
{
	static int heap[];

	static int left(int i){
		return 2*i+1;
	}

	static int right(int i){
		return 2*i+2;
	}

	static int parent(int i){
		return (i-1)/2;
	}

	static void minHeapify(int index){
		int n = heap.length;
		int left = left(index);
		int right = right(index);
		if(left<n && right<n && (heap[left]<heap[index] || heap[right]<heap[index])){
			if(heap[left]<heap[right]){
				swap(index, left);
				index = left;
			}
			else{
				swap(index, right);
				index = right;
			}
			left = left(index);
			right = right(index);
			minHeapify(index);
		}
	}

	static void swap(int i, int j){
		heap[i] = heap[i]+heap[j];
		heap[j] = heap[i]-heap[j];
		heap[i] = heap[i]-heap[j];
	}

	static void printHeap(int n){
		for (int i=0; i<n; i++) {
			System.out.print(heap[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		heap = new int[]{40, 20, 30, 45, 25, 80, 32, 100, 70, 60};
		int index = 0;
		int n = heap.length;
		minHeapify(index);
		printHeap(n);
	}
}