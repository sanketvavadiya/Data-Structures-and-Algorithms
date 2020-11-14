class Node
{
	int data;
	Node next;
	Node(int d){
		data = d;
		next = null;
	}
}
class StackUsingLL
{
	Node head;
	void push(int data){
		Node temp = new Node(data);
		if(head!=null)
			temp.next = head;
		head = temp;
	}

	void pop(){
		if(head == null)
			System.out.println("Stack is empty");
		else{
			System.out.println("Deleted: "+head.data);
			head = head.next;
		}
	}

	void printStack(){
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		StackUsingLL obj = new StackUsingLL();
		obj.pop();
		obj.push(5);
		obj.push(8);
		obj.printStack();
		obj.pop();
		obj.printStack();
	}
}