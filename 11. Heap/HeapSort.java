package classFiles;
import java.util.Random;
class HeapSort{
	static int []heap;
	static int capacity, size;

	static int left(int i){
		return 2*i+1;
	}

	static int right(int i){
		return 2*i+2;
	}

	static int parent(int i){
		return (i-1)/2;
	}

	static void heapify(int i){
		int left = left(i), right = right(i);
		int largest = i;
		if(left<size && heap[left]>heap[largest])
			largest = left;
		if(right<size && heap[right]>heap[largest])
			largest = right;
		if(largest!=i){
			swap(largest, i);
			heapify(largest);
		}
	}

	static void buildHeap(){
		for (int i=parent(size-1); i>=0; i--) {
			heapify(i);
		}
	}

	static void extractMax(){
		int n = size;
		for (int i=size-1; i>0; i--) {
			swap(0, i);
			size--;
			heapify(0);
		}
		size = n;
	}

	static void swap(int i, int j){
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	static void printHeap(){
		for (int i=0; i<size; i++) {
			System.out.print(heap[i]+" ");
		}
		System.out.println();	
	}

	public static void main(String[] args) {
		Random rd = new Random();
		capacity = 10;
		size = 0;
		heap = new int[capacity];
		for (int i=0; i<capacity; i++) {
			heap[i] = Math.abs(rd.nextInt()/10000000);
			size++;
		}
		printHeap();

		// build Heap
		buildHeap();
		// printHeap();

		// extract max
		extractMax();
		printHeap();
	}
}