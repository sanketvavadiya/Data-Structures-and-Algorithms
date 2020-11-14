// { Driver Code Starts
import java.util.*;

class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}

class CheckPalindrome
{
	 Node head;  
	 Node tail;
	
	/* Function to print linked list */
    void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	
 
    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) 
	{

		if (head == null) 
		{
			head = node;
			tail = node;
		} else 
		{
		    tail.next = node;
		    tail = node;
		}
    }
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		 
		while(t>0)
        {
			int n = sc.nextInt();
			//int k = sc.nextInt();
			CheckPalindrome llist = new CheckPalindrome();
			//int n=Integer.parseInt(br.readLine());
			int a1=sc.nextInt();
			Node head= new Node(a1);
            Node tail = head;
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
			    tail.next = new Node(a);
			    tail = tail.next;
			}
			
			Palindrome g = new Palindrome();
			if(g.isPalindrome(head) == true)
			    System.out.println(1);
		    else
			    System.out.println(0);
			t--;
		}
		
	}
}



// } Driver Code Ends


/* Structure of class Node is
class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}*/

class Palindrome
{
    // Function to check if linked list is palindrome
    Node newHead;
    boolean isPalindrome(Node head) 
    {
        //Your code here
        if(head.next==null)
        	return true;
        int n = countNode(head);
        if(n==2){
        	System.out.println(head.data+" "+head.next.data);
        	if(head.data == head.next.data)
        		return true;
        	else
        		return false;
        }
        Node half = head;
        int nby2 = n/2;
        while(nby2-->0){
        	half = half.next;
        }

        // System.out.println("half: "+half.data);

        while(half!=null){
     		insert(half.data);
     		half = half.next;
        }
        // CheckPalindrome obj = new CheckPalindrome();
        // obj.printList(newHead);
        nby2=n/2;
        while(nby2-->0){
        	if(head.data != newHead.data)
        		return false;
        	head = head.next;
        	newHead = newHead.next;
        }
        return true;
    }
    int countNode(Node head)
    {
    	int n = 1;
    	Node curr = head;
    	while(curr.next!=null){
    		n++;
    		curr = curr.next;
    	}
    	return n;
    }

    void insert(int data)
    {
    	Node temp = new Node(data);
    	if(newHead == null)
    		newHead = temp;
    	else
    		temp.next = newHead;
    	newHead = temp;
    }
}

