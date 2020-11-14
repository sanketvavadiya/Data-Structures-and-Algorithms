package classFiles;
import java.util.Random;
class MaxHeap{
	static int heap[];
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

	static void insert(int val){
		if(size<capacity){
			heap[size] = val;
			int i = size;
			while(i>0 && heap[parent(i)]<heap[i]){
				swap(parent(i), i);
				i = parent(i);
			}
			size++;
		}
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
		capacity = 10;
		size = 0;
		heap = new int[capacity];
		Random rd = new Random();

		for (int i=0; i<capacity; i++) {
			insert(Math.abs(rd.nextInt()/10000000));
		}
		printHeap();
	}
}