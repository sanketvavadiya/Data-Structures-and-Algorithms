// { Driver Code Starts



import java.util.*;
import java.util.*;
import java.io.*;

class Node
{
    int data;
    Node next, prev;
    Node(int key)
    {
        data = key;
        next = prev = null;
    }
}

class MergeSortDoublyLL
{
    public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    
	    while(t-- > 0)
	    {
	        int n = sc.nextInt();
	        int a1 = sc.nextInt();
	        Node head = new Node(a1);
	        Node temp = head;
	        
	        for (int i = 1;i < n;i++)
	        {
	            int a = sc.nextInt();
	            Node n1 = new Node(a);
	            n1.prev = temp;
	            temp.next = n1;
	            temp = n1;
	        }
	        
	        head = new LinkedList().sortDoubly(head);
	        printList(head);
	    }
	}
	public static void printList(Node node)
	{
	    Node temp = node;
	    while(node != null)
	    {
	        System.out.print(node.data + " ");
	        temp = node;
	        node = node.next;
	    }
	    System.out.println();
	    while(temp != null)
	    {
	        System.out.print(temp.data + " ");
	        temp = temp.prev;
	    }
	    System.out.println();
	}
}
// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}
*/
class LinkedList
{
    static Node sortDoubly(Node head)
    {
        // add your code here
        if(head == null || head.next == null)
        	return head;
        Node mid = partition(head);
        return merge(sortDoubly(head), sortDoubly(mid));
    }

    static Node partition(Node head)
    {
    	if(head == null)
    		return head;
    	Node fast = head;
    	Node slow = head;
    	while(fast.next != null && fast.next.next !=null){
    		fast = fast.next.next;
    		slow = slow.next;
       	}
    	Node mid = slow.next;
    	mid.prev = null;
    	slow.next = null;
    	return mid;
    }

    static Node merge(Node head1, Node head2)
    {
    	if(head1 == null)
    		return head2;
    	else if(head2 == null)
    		return head1;
    	Node head, tail;
    	if(head1.data < head2.data){
    		head = head1;
    		head1 = head1.next;
    	}
    	else{
    		head = head2;
    		head2 = head2.next;
    	}
    	tail = head;
    	head.next = null;
    	tail.next = null;
    	while(head1!=null && head2!=null){
    		if(head1.data < head2.data){
    			tail.next = head1;
    			head1 = head1.next;
    		}
    		else{
    			tail.next = head;
    			head2 = head2.next;
    		}
    		tail.next.prev = tail;
    		tail = tail.next;
    	}
    	while (head1!=null) {
    		tail.next = head1;
    		tail.next.prev = tail;
    		tail = tail.next;
    		head1 = head1.next;
    	}
    	while(head2!=null){
    		tail.next = head2;
    		tail.next.prev = tail;
    		tail = tail.next;
    		head2 = head2.next;
    	}
    	tail.next = null;
    	return head;
    }
}