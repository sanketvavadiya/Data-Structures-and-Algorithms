// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

 //static Node head; 
  
   class Node { 
  
        int data; 
        Node next; 
  
        Node(int d) { 
            data = d; 
            next = null; 
        } 
    } 

public class PairwiseSwap
{
    static  Node head;  // head of lisl
    static  Node lastNode;
    //static PrintWriter out;
    /* Linked list Node*/


    /* Utility functions */

    /* Inserts a new Node at front of the list. */
    public static void addToTheLast(Node node)
    {

        if (head == null)
        {
            head = node;
            lastNode = node;
        }
        else
        {
            lastNode.next = node;
            lastNode = node;
        }
    }
    /* Function to print linked list */
     static void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        //System.out.println();
    }



    /* Drier program to test above functions */
    public static void main(String args[]) throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //out = new PrintWriter(new BufferedOutputStream(System.out));
        int t= Integer.parseInt(br.readLine());
            
        while(t>0)
        {
            int n = Integer.parseInt(br.readLine());
            Node head = null;

            //LinkedList1 llist = new LinkedList1();
                        String str = br.readLine();
                        String nums[] = str.trim().split("\\s+");
            
                int a1= Integer.parseInt(nums[0]);
                head= new Node(a1);
                addToTheLast(head);
            
            for (int i = 1; i < n; i++)
            {
                int a = Integer.parseInt(nums[i]);
                addToTheLast(new Node(a));
            }


            head = new Swap().pairwise_swap(head);
            
            printList(head);
            System.out.println();
            
            t--;
        }
        //out.close();
    }
}

 // } Driver Code Ends


//User function Template for Java

/*class Node { 
  
        int data; 
        Node next; 
  
        Node(int d) { 
            data = d; 
            next = null; 
        } 
    } */
class Swap
{
    public static Node pairwise_swap(Node head)
    {
        // your code here
        if(head == null || head.next == null)
            return head;
        Node prev = head.next;
        Node curr = head.next.next;
        prev.next = head;
        head = head.next;
        prev = prev.next;
        System.out.println("head: "+head.data);
        System.out.println("head: "+prev.data);
        System.out.println("head: "+curr.data);
        while(curr != null && curr.next!=null){
            Node nxt = curr.next.next;
            prev.next = curr.next;
            prev = curr;
            curr.next.next = curr;
            curr = nxt;
        }
        prev.next = curr;
        return head;
    }       
}

// { Driver Code Starts
  // } Driver Code Ends