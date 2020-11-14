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

class MergeSort
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
           
              head = new LinkedList().mergeSort(head);
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
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class LinkedList
{
    static Node mergeSort(Node head)
    {
        // add your code here
        if(head == null || head.next == null)
            return head;
        Node mid = partition(head);
        return merge(mergeSort(head), mergeSort(mid));
    }
    
    static Node partition(Node head){
        Node fast = head.next;
        Node slow = head;
        while(fast!=null){
            fast = fast.next;
            if(fast!=null){
                fast = fast.next;
                slow = slow.next;
            }
        }
        Node mid = slow.next;
        slow.next = null;
        return mid;
    }

    static Node merge(Node headA, Node headB) {
     // This is a "method-only" submission. 
     // You only need to complete this method
     Node temp, head;
     if(headA.data < headB.data){
         temp = headA;
         headA = headA.next;
     }
     else{
         temp = headB;
         headB = headB.next;
     }
     head = temp;
     while(headA != null && headB != null){
        if(headA.data < headB.data){
            temp.next = headA;
            headA = headA.next;
        }
        else{
            temp.next = headB;
            headB = headB.next;
        }
        temp = temp.next;
     }

     while(headA != null){
        temp.next = headA;
        headA = headA.next;
        temp = temp.next;
     }
     while(headB != null){
        temp.next = headB;
        headB = headB.next;
        temp = temp.next;
     }
     return head;
   } 
}


