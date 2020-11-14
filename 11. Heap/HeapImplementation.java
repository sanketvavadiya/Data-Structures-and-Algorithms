package classFiles;
import java.util.Random;
class HeapImplementation
{
	int heap[];
	int size, capacity;
	HeapImplementation(int size){
		capacity = size;
		this.size = 0;
		heap = new int[capacity];
	}
	int getLeft(int i){
		return 2*i+1;
	}

	int getRight(int i){
		return 2*i+2;
	}

	int getParent(int i){
		return (i-1)/2;
	}

	void insert(int val){
		if(size<capacity){
			heap[size] = val;
			int i = size;
			while(i>0 && heap[i]<heap[getParent(i)]){
				swap(i, getParent(i));
				i = getParent(i);
			}
			size++;
		}
	}

	int extractMin(){
		if(size == 0)
			return Integer.MAX_VALUE;
		int removed = heap[0];
		swap(0, size-1);
		size--;
		minHeapify(0);
		return removed;
	}

	void minHeapify(int index){
		int left = getLeft(index);
		int right = getRight(index);
		if(left<size && right<size && (heap[left]<heap[index] || heap[right]<heap[index])){
			if(heap[left]<heap[right]){
				swap(left, index);
				index = left;
			}
			else{
				swap(right, index);
				index = right;
			}
			left = getLeft(index);
			right = getRight(index);
			minHeapify(index);
		}
	}

	void decreaseKey(int i, int new_value){
		heap[i] = new_value;

		// check for children
		minHeapify(i);

		// check for parent
		if(heap[i]<heap[getParent(i)]){
			while(i>0 && heap[i]<heap[getParent(i)]){
				swap(i, getParent(i));
				i = getParent(i);
			}
		}
	}

	int delete(int i){
		swap(i, size-1);
		size--;
		minHeapify(i);
		while(i>0 && heap[i]<heap[getParent(i)]){
			swap(i, getParent(i));
			i = getParent(i);
		}
		return heap[size+1];
	}

	void printHeap(){
		for (int i=0; i<size; i++) {
			System.out.print(heap[i]+" ");
		}
		System.out.println();
	}

	void swap(int i, int j){
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	public static void main(String[] args) {
		int n = 10;
		Random rd = new Random();
		HeapImplementation obj = new HeapImplementation(n);
		for (int i=0; i<n; i++) {
			obj.insert(Math.abs(rd.nextInt()/10000000));
		}
		obj.printHeap();

		System.out.println("Item removed: "+obj.extractMin());
		obj.printHeap();

		int index = 3, new_value = Integer.MAX_VALUE;
		obj.decreaseKey(index, new_value);
		obj.printHeap();

		index = 3;
		System.out.println("Deleted: "+obj.delete(index));
		obj.printHeap();
	}
}