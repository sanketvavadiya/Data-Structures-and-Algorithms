// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class SegreagateZeroOneTwo
{
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new LinkedList().segregate(head);
		     printList(head);
		    System.out.println();
        }
    }
    
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}



// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class LinkedList
{
    Node zeroHead, zeroTail, oneHead, oneTail, twoHead, twoTail;
    Node segregate(Node head)
    {
        // add your code here
        if(head == null || head.next==null)
            return head;
        while(head!=null){
            if(head.data == 0)
                addZero(head.data);
            else if(head.data == 1)
                addOne(head.data);
            else
                addTwo(head.data);
            head = head.next;
        }
        if(zeroHead == null){
            if(oneHead != null)
                zeroHead = oneHead;
            else
                zeroHead = twoHead;
        }

        else{
            if(oneHead != null)
                zeroTail.next = oneHead;
            else if(twoHead != null)
                zeroTail.next = twoHead;
        }

        if(twoHead != null){
            if(oneHead != null)
                oneTail.next = twoHead;
        }

        return zeroHead;
    }

    void addZero(int data){
        Node temp = new Node(data);
        if(zeroHead == null)
            zeroHead = temp;
        else
            zeroTail.next = temp;
        zeroTail = temp;
    }

    void addOne(int data){
        Node temp = new Node(data);
        if(oneHead == null)
            oneHead = temp;
        else
            oneTail.next = temp;
        oneTail = temp;
    }    

    void addTwo(int data){
        Node temp = new Node(data);
        if(twoHead == null)
            twoHead = temp;
        else
            twoTail.next = temp;
        twoTail = temp;
    }
}


