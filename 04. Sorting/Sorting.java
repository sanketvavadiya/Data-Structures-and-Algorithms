import java.util.Random;
class Sorting
{
	public static void main(String[] args) {
		Sort obj = new Sort(5);
		obj.takeInput();
		System.out.print("Array: ");
		obj.printArray();

		// System.out.print("Bubble sort: ");
		// obj.bubbleSort();

		// System.out.print("Selection sort: ");
		// obj.selectionSort();

		System.out.print("Insertion sort: ");
		obj.insertionSort();

		// System.out.print("Merge Sort: ");
		// obj.mergeSort(0, obj.n-1);
		// obj.printArray();

		// System.out.print("Quick Sort: ");
		// obj.quickSort(0, obj.n-1);
		// obj.printArray();

		// System.out.print("Counting Sort: ");
		// obj.countingSort();
	}
}

class Sort
{
	int n;
	int []arr;
	Sort(int size){
		n = size;
		arr = new int[n];
	}

	void takeInput(){
		Random rd = new Random();
		for (int i=0; i<n; i++) {
			arr[i] = rd.nextInt()/10000000;
			// arr[i] = Math.abs(rd.nextInt()%10);	//	for countitng sort only
		}
	}

	void printArray(){
		for (int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	void bubbleSort(){
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if(i!=j && arr[j]>arr[i]){
					// swap
					arr[i] = arr[i]+arr[j];
					arr[j] = arr[i]-arr[j];
					arr[i] = arr[i]-arr[j];
				}
			}
		}
		printArray();
	}

	void selectionSort(){
		for (int i=0; i<n; i++) {
			int min = i;
			for (int j=i+1; j<n; j++) {
				if(arr[min]>arr[j])
					min = j;
			}
			// swap
			arr[i] = arr[min]+arr[i];
			arr[min] = arr[i]-arr[min];
			arr[i] = arr[i]-arr[min];
		}
		printArray();
	}

	void insertionSort(){
		for (int i=0; i<n; i++) {
			int j = i-1;
			int key = arr[i];
			while(j>=0 && arr[j]>key){
				arr[j+1] =arr[j];
				j--;
			}
			arr[j+1] = key;
		}
		printArray();
	}

	void mergeSort(int l, int h){
		if(l<h){
			int mid = (l+h)/2;
			mergeSort(l, mid);
			mergeSort(mid+1, h);
			merge(l, mid, h);
		}
	}

	void merge(int l, int mid, int h){
		int i=l, j=mid+1, k=0;
		int temp[] = new int[h-l+1];
		while(i<=mid && j<=h){
			if(arr[i]<arr[j])
				temp[k++] = arr[i++];
			else
				temp[k++] = arr[j++];
		}
		while(i<=mid)
			temp[k++] = arr[i++];
		while(j<=h)
			temp[k++] = arr[j++];
		for (i=l; i<=h; i++) {
			arr[i] = temp[i-l];
		}
	}

	void quickSort(int l, int h){
		if(l<h){
			int pi = pivot(l, h);
			quickSort(l, pi-1);
			quickSort(pi+1, h);
		}
	}

	int pivot(int l, int h){
		int pivot = arr[h];
		int i=l-1;
		for (int j=l; j<h; j++) {
			if(arr[j] < pivot){
				i++;
				//swap
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		// temp
		int temp = arr[i+1];
		arr[i+1] = arr[h];
		arr[h] = temp;
		return i+1;
	}

	void countingSort(){
		int count[] = new int[10];
		int res[] = new int[n];
		for (int i=0; i<n; i++) {
			count[arr[i]]++;
		}
		for (int i=1; i<10; i++) {
			count[i] += count[i-1];
		}
		for (int i=0; i<n; i++) {
			res[count[arr[i]]-1] = arr[i];
			count[arr[i]]--;
		}
		for (int i=0; i<n; i++) {
			arr[i] = res[i];
		}
		printArray();
	}
}