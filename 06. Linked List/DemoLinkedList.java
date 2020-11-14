class Node
{
	int data;
	Node next;
	Node(int x){
		data = x;
	}
}

class LList
{
	Node head;
	void insertBegin(int x)
	{
		Node temp = new Node(x);
		temp.next = head;
		head = temp;
	}
	void printList()
	{
		Node temp = head;	
		while(temp!=null){
			System.out.print(temp.data+"->");
			temp = temp.next;
		}
		System.out.println();
	}
	void insertEnd(int x)
	{
		Node temp1 = head;
		if(temp1 == null){
			insertBegin(x); 
			return;
		}

		while(temp1.next!=null)
			temp1 = temp1.next;
		Node temp2 = new Node(x);
		temp1.next = temp2;
	}
}

class DemoLinkedList
{
	public static void main(String[] args) {
		LList ll = new LList();

		ll.insertBegin(20);
		ll.insertBegin(5);
		ll.insertBegin(25);	
		ll.printList();
		ll.insertEnd(30);
		ll.insertEnd(50);
		ll.printList();
	}
}