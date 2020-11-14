class Node
{
	int data;
	Node next, prev;
	Node(int x){
		data = x;
		next = null;
		prev = null;
	}
}
class CircularDoubly
{
	Node head;
	Node tail;
	void printList(){
		Node temp = head;
		while(temp!=tail){
			System.out.print(temp.data + " ");
			temp=temp.next;
		}
		System.out.print(temp.data + " ");
		System.out.println();
	}

	void insertBegin(int x)
	{
		Node temp = new Node(x);
		if(head == null){
			tail = temp;
			head = temp;
			return;
		}
		temp.prev = head.prev;
		temp.next = head;
		head.prev = temp;
		tail.next = temp;

		head = temp;
	}

	void insertEnd(int x){
		Node temp = new Node(x);
		if(head == null){
			tail = temp;
			head = temp;
			return;
		}
		temp.prev = tail;
		temp.next = head;
		head.prev = temp;
		tail.next = temp;

		tail = tail.next;
	}

	void insertAfter(int val, int x)
	{
		Node curr = head;
		while(curr.data != val && curr != tail)
			curr = curr.next;
		if(curr == tail && curr.data == val)
			insertEnd(x);
		else{
			Node temp =  new Node(x);
			temp.next = curr.next;
			temp.prev = curr;
			curr.next.prev = temp;
			curr.next = temp;
		}
	}

	void insertBefore(int val, int x)
	{
		Node curr = head;
		while(curr.data != val && curr != tail)
			curr = curr.next;

		if(curr == head)
			insertBegin(x);
		else{
			Node temp = new Node(x);
			temp.next = curr;
			temp.prev = curr.prev;
			curr.prev.next = temp;
			curr.prev = temp;
		}
	}

	void delete(int val)
	{
		Node curr = head;
		while(curr.data != val && curr != tail)
			curr = curr.next;
		if(curr.data == val){
			curr.prev.next = curr.next;
			curr.next.prev = curr.prev;
			if(curr == head)
				head = head.next;
			else if(curr == tail)
				tail = tail.prev;
		}
	}
}

class CircularDoublyDemo
{
	public static void main(String[] args) {
		CircularDoubly ll = new CircularDoubly();

		ll.insertBegin(3);
		ll.insertBegin(2);
		ll.insertBegin(1);
		ll.insertEnd(4);
		ll.insertEnd(5);

		ll.printList(); 	//1 2 3 4 5

		ll.insertAfter(1, 17);
		ll.insertAfter(5, 13);
		ll.insertAfter(3, 10);

		ll.printList(); 	//1 17 2 3 10 4 5 13

		ll.insertBefore(1, 20);
		ll.insertBefore(2, 12);
		ll.insertBefore(13, 27);

		ll.printList(); 	//20 1 17 12 2 3 10 4 5 27 13

		ll.delete(10);
		ll.delete(20);
		ll.delete(12);
		ll.delete(27);
		ll.delete(13);
		ll.delete(17);

		ll.printList();
	}
}