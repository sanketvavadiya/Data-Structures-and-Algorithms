// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

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

class SwapKthNode
{
    static  Node head;  
    static  Node lastNode;
    
    public static void addToTheLast(Node node)
    {

        if (head == null)
        {
            head = node;
            lastNode = node;
        }
        else
        {
            Node temp = head;
            lastNode.next = node;
            lastNode = node;
        }
    }
    void printList(Node head)
    {
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp =temp.next;
        }
        
    }
    public static void main(String args[])
    {
        Scanner sc=  new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n, K;
            n = sc.nextInt();
            K = sc.nextInt();
            
            Node head = null;
            int val = sc.nextInt();
            head = new Node(val);
            addToTheLast(head);
            
            for(int i = 1; i< n; i++)
            {
                val = sc.nextInt();
                addToTheLast(new Node(val));
            }
            
            Node before[] = new Node[n];
            addressstore(before, head);
            GFG obj = new GFG();
            
            head = obj.swapkthnode(head, n, K);
        
           Node after[] = new Node[n];
          addressstore(after, head);
        
        if(check(before, after, n, K) == true)
            System.out.println("1");
        else
            System.out.println("0");
        
        }
    }
    
    static boolean check(Node before[], Node after[], int num, int K)
    {
          if(K > num)
           return true;
           
           return (before[K-1] == after[num - K]) && (before[num-K] == after[K-1]);
              
       
    }
    
    static void addressstore(Node arr[], Node head)
  {
      Node temp = head;
      int i = 0;
      while(temp != null){
        arr[i] = temp;
        i++;
        temp = temp.next;
    }
}
    
}// } Driver Code Ends
//User function Template for Java


/* Linked List Node class
   class Node  {
     int data;
     Node next;
     Node(int data)
     {
         this.data = data;
         next = null;
     }
  }
*/
class GFG
{
    // Should swap Kth node from beginning and 
    // Kth node from end in list and return new head.
    Node swapkthnode(Node head, int num, int k)
    {
        // your code here
        int n = countNode(head);
        if(n<k || 2*k-1 == n)
            return head;

        Node x = head;
        Node x_prev = null;
        int i=k;
        while(i-->1){
            x_prev = x;
            x = x.next;
        }

        Node y = head;
        Node y_prev = null;
        i=n-k;
        while(i-->0){
            y_prev = y;
            y = y.next;
        }

        if(x_prev!=null)
            x_prev.next = y;
        if(y_prev!=null)
            y_prev.next = x;

        Node temp = x.next;
        x.next = y.next;
        y.next = temp;

        new SwapKthNode().printList(head);
        if(k==1)
            return y;
        else if(k==n)
            return x;
        return head;
    }
    int countNode(Node head)
    {
        Node curr = head;
        int n=0;
        while(curr!=null){
            curr=curr.next;
            n++;
        }
        return n;
    }
}
