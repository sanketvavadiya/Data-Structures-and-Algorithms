/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
	int data;
	Node next;
	Node(int d){
		data = d;
	}
}

class SegreagateEvenOdd {
	Node head, tail;
	void insert(int data){
		Node temp = new Node(data);
		if (head == null) {
			head = temp;
		}
		else
			tail.next =temp;
		tail = temp;
	}

	public static void main (String[] args) throws IOException{
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0){
			int n = Integer.parseInt(br.readLine());
			String in[] = br.readLine().trim().split(" ");

			SegreagateEvenOdd obj = new SegreagateEvenOdd();
			for(int i=0; i<n; i++)
				obj.insert(Integer.parseInt(in[i]));

			new MyClass().segregate(obj.head, obj.tail);
		}
	}
}

class MyClass
{
	Node evenHead, evenTail, oddHead, oddTail;
	void segregate(Node head, Node tail)
	{
		Node temp = head;
		while(temp!=null){
			if(temp.data%2 == 0)
				addEven(temp.data);
			else
				addOdd(temp.data);
			temp = temp.next;
		}
		if(evenTail != null)
			evenTail.next = oddHead;
		else
			evenHead = oddHead;
		printList(evenHead);
	}

	void addEven(int data){
		Node temp = new Node(data);
		if(evenHead == null)
			evenHead = temp;
		else
			evenTail.next = temp;
		evenTail = temp;
	}

	void addOdd(int data){
		Node temp = new Node(data);
		if(oddHead == null)
			oddHead = temp;
		else
			oddTail.next = temp;
		oddTail = temp;
	}

	void printList(Node head){
		Node temp = head;
		StringBuffer sb = new StringBuffer();
		while(temp!=null){
			sb.append(temp.data+" ");
			temp = temp.next;
		}
		System.out.println(sb);
	}
}