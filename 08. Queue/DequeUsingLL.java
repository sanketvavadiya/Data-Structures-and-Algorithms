class Node<E>
{
	E data;
	Node<E> next;
	Node<E> prev;
	Node(E data){
		this.data = data;
		next = prev = null;
	}
}
class DequeUsingLL<E>
{
	Node<E> front;
	Node<E> rear;

	void enqFront(E x){
		Node<E> temp = new Node<E>(x);
		if(front == null){
			front = rear = temp;
		}
		else{
			front.prev = temp;
			temp.next = front;
			front = front.prev;
		}
	}

	void enqRear(E x){
		Node<E> temp = new Node<E>(x);
		if(rear == null){
			front = rear = temp;
		}
		else{
			rear.next = temp;
			temp.prev = rear;
			rear = rear.next;
		}
	}

	void dqFront(){
		if(front == null)
			System.out.println("Underflow");
		else{
			System.out.println("Deleted: "+front.data);
			front = front.next;
		}
	}

	void dqRear(){
		if(rear == null)
			System.out.println("Underflow");
		else{
			System.out.println("Deleted: "+rear.data);
			rear = rear.prev;
			rear.next = null;
		}
	}

	void printDQ(){
		for(Node temp=front;temp!=null;temp=temp.next)
			System.out.print(temp.data+" ");
		System.out.println();
	}

	public static void main(String[] args) {
		DequeUsingLL<Integer> obj = new DequeUsingLL<Integer>();	
		obj.dqFront(); // underflow
		obj.enqFront(3);
		obj.enqRear(2);
		obj.enqFront(5);
		obj.enqRear(1);
		obj.enqRear(5);
		obj.enqFront(7);
		obj.enqRear(7);
		obj.printDQ(); // 7 5 3 2 1 5 7 
		obj.dqFront();
		obj.dqRear();
		obj.printDQ(); // 5 3 2 1 
		obj.enqFront(5);
		obj.enqRear(3);
		obj.enqRear(7);
		obj.printDQ(); // 5 5 3 2 1 5 3 7
	}
}