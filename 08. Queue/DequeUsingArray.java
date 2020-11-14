class DequeUsingArray<E>
{
	E q[];
	int capacity, front, rear, size;
	DequeUsingArray(int capacity){
		this.capacity = capacity;
		rear = front = -1;
		size = 0;
		// @SuppressWarnings("unchecked")
		// E arr[] = (E[]) new Object[capacity];
		q = (E[]) new Object[capacity];
	}

	boolean isFull(){
		if(size==capacity)
			return true;
		return false;
	}

	boolean isEmpty(){
		if(size == 0)
			return true;
		return false;
	}

	void enqFront(E x){
		if(isFull())
			System.out.println("Overflow");
		else if(size == 0){
			front = rear = 0;
			q[front] = x;
			size++;
		}
		else{
			front = (front-1)%capacity;
			if(front < 0)
				front = front + capacity;
			q[front] = x;
			size++;
		}
	}

	void enqRear(E x){
		if(isFull())
			System.out.println("Overflow");
		else if(size == 0){
			front = rear = 0;
			q[rear] = x;
			size++;
		}
		else{
			rear = (rear+1)%capacity;
			q[rear] = x;
			size++;
		}
	}

	void dqFront(){
		if(isEmpty())
			System.out.println("Underflow");
		else{
			System.out.println("Deleted: "+q[front]);
			front = (front+1)%capacity;
			size--;
		}
	}

	void dqRear(){
		if(isEmpty())
			System.out.println("Underflow");
		else{
			System.out.println("Deleted: "+q[rear]);
			rear = (rear-1)%capacity;
			if(rear<0)
				rear = rear+capacity;
			size--;
		}
	}

	void printDQ(){
		for(int i=front, j=0;j<size;i=(i+1)%capacity, j++){
			System.out.print(q[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		DequeUsingArray<String> obj = new DequeUsingArray<String>(5);
		obj.dqRear();	//Underflow
		obj.dqFront();	//Underflow
		obj.enqFront("5");
		obj.enqRear("3");
		obj.enqFront("7");
		obj.enqFront("2");
		obj.enqRear("6");
		obj.printDQ();	//2 7 5 3 6
		obj.enqFront("8");	//Overflow
		obj.dqFront();
		obj.dqRear();
		obj.printDQ();	//7 5 3
		obj.enqFront("8");
		obj.enqFront("10");
		obj.enqFront("18");	//Overflow;
		obj.printDQ();	//10 8 7 5 3
		obj.dqRear();
		obj.dqFront();
		obj.dqRear();
		obj.printDQ();	//8 7
		obj.dqFront();
		obj.dqFront();
		obj.printDQ(); 	//
		obj.dqFront();	//Underflow
		obj.dqRear();	//Underflow
	}
}