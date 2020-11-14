class QueueUsingArray
{
	int queue[];
	int size = 10, front, rear;
	QueueUsingArray(int size){
		this.size = size;
		queue = new int[size];
		front = -1;
		rear = -1;
	}

	void enqueue(int data){
		if (rear == size-1 && front == 0) {
			System.out.println("Overflow");
		}
		else if(rear == front-1)
			System.out.println("Overflow");
		else{
			rear = (rear+1)%size;
			queue[rear] = data;
			if(front == -1) front = 0;
		}
	}

	void dequque(){
		if(front == -1)
			System.out.println("Underflow");
		else if(front == rear)
		{
			System.out.println("Deleted: "+queue[front]);
			front = rear = -1;
		}
		else
		{
			System.out.println("Deleted: "+queue[front]);
			front = (front+1)%size;
		}
	}

	void printQ(){

		for (int i=front, j=(rear - front + size)%size + 1; j-- > 0 && front>=0; i=(i+1)%size) {
			System.out.print(queue[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		QueueUsingArray obj = new QueueUsingArray(5);
		obj.dequque();	//underflow
		obj.enqueue(5);
		obj.enqueue(3);
		obj.enqueue(2);
		obj.enqueue(1);
		obj.enqueue(5);
		obj.enqueue(7);	//overflow
		obj.printQ();	//5 3 2 1 5
		obj.dequque();
		obj.dequque();
		obj.printQ();	//2 1 5
		obj.enqueue(5);
		obj.enqueue(3);
		obj.enqueue(7);	//overflow
		obj.printQ();
	}
}