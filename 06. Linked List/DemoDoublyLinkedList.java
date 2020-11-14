import java.util.Scanner;

class Node
{
	int data;
	Node next;
	Node prev;
	Node(int x){
		data = x;
		next = null;
		prev = null;
	}
}

class DoublyLinkedList
{
	Node head;
	void insertBegin(int x){
		Node temp = new Node(x);
		if(head!=null){
			head.prev = temp;
			temp.next = head;
		}
		head = temp;
	}

	void printList(){
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		System.out.println();
	}

	void insertEnd(int x){
		if(head == null){
			insertBegin(x);
			return;
		}
		Node temp1 = head;
		while(temp1.next!=null)
			temp1 = temp1.next;
		Node temp2 = new Node(x);
		temp2.prev = temp1;
		temp1.next = temp2;
	}

	void insertAfter(int val, int x){
		Node temp = head;
		Node temp2 = new Node(x);
		while(temp.next !=  null && temp.data != val)
			temp = temp.next;
		if(temp.data != val){
			System.out.print("Value not found!");
			return;
		}
		else{
			temp2.prev = temp;
			temp2.next = temp.next;
			temp.next = temp2;
			temp = temp.next;
		}
		if(temp.next!=null){
			temp.prev = temp2;
		}
	}

	void insertBefore(int val, int x){
		Node temp2 = head;
		Node temp1 = temp2.next;
		if(temp2.data == val){
			insertBegin(x);
			return;
		}
		while(temp1.next!=null && temp1.data!=val){
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		if(temp1.data != val){
			System.out.print("Value not found!");
			return;
		}
		else{
			Node temp = new Node(x);
			temp.next = temp1;
			temp.prev = temp2;
			temp1.prev = temp;
			temp2.next = temp;
		}
	}

	void delete(int val){
		Node temp = head;
		while(temp.next!=null && temp.data!=val){
			temp = temp.next;
		}

		//if value no present in the list
		if(temp.data != val){
			System.out.println("Value not found!");
			return;	
		}

		//deleting first node
		else if(temp.prev == null){
			head = head.next;
			return;
		}

		//deleting last node
		else if(temp.next == null){
			temp.prev.next = null;
			return;
		}
		else{
			Node temp1 = temp.prev;	//for node before given node
			Node temp2 = temp.next;	//for node after given node
			temp1.next = temp.next;
			temp2.prev = temp.prev;
		}
	}
}

class DemoDoublyLinkedList
{
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		Scanner sc = new Scanner(System.in);

		while(true){
			System.out.println("1. insertBegin\n2. insertEnd\n3. insertAfter\n4. insertBefore");
			System.out.println("5. delete\n6. printList\n0. Exit");
			System.out.print("Coice: ");
			int ch = sc.nextInt();
			switch(ch){
				case 1:
					System.out.print("Value to insert: ");
					dll.insertBegin(sc.nextInt());
					dll.printList();
					break;
				case 2:
					System.out.print("Value to insert: ");
					dll.insertEnd(sc.nextInt());
					dll.printList();
					break;
				case 3:
					System.out.print("First node value then new value: ");
					dll.insertAfter(sc.nextInt(), sc.nextInt());
					dll.printList();
					break;
				case 4:
					System.out.print("First node value then new value: ");
					dll.insertBefore(sc.nextInt(), sc.nextInt());
					dll.printList();
					break;
				case 5:
					System.out.print("Enter value to delete: ");
					dll.delete(sc.nextInt());
					dll.printList();
					break;
				case 6:
					dll.printList();
					break;
				case 0:
					System.exit(0);
			}
		}
	}
}