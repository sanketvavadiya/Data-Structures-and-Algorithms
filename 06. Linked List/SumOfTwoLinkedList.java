// { Driver Code Starts
import java.util.*;
class Node {
    int data;
    Node next;

    Node() {}
    Node(int d) {
        data = d;
        next = null;
    }
} 
class SumOfTwoLinkedList {
    Node head;

    void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        // System.out.println("");
    }

    public void push(int new_data) {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n1 = sc.nextInt();
            SumOfTwoLinkedList list1 = new SumOfTwoLinkedList();
            for (int i = 1; i <= n1; i++) {
                int a = sc.nextInt();
                list1.push(a);
            }
            int n2 = sc.nextInt();
            SumOfTwoLinkedList list2 = new SumOfTwoLinkedList();
            for (int i = 0; i < n2; i++) {
                int b = sc.nextInt();
                list2.push(b);
            }
            SumOfTwoLinkedList list3 = new SumOfTwoLinkedList();
            Add g = new Add();
            Node rs = g.addTwoLists(list1.head, list2.head);
            list3.printList(rs);
            System.out.println();
            T--;
        }
    }
}// } Driver Code Ends


/*The Node is defined as
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
        Node(){}
    }
*/

class Add {
    
    // This function will add the numbers represented by two linked lists
    Node res, last;
    Node addTwoLists(Node first, Node second) {
        // Your code here
        int carry=0;
        while(first!=null || second!=null){
            int curr_sum;
            if(first == null){
                curr_sum = second.data+carry;
                second = second.next;
            }

            else if(second == null){
                curr_sum = first.data+carry;
                first = first.next;
            }

            else{
                curr_sum = first.data+second.data+carry;
                first = first.next;
                second = second.next;
            }

            if(curr_sum<10){
                insertEnd(curr_sum);
                carry = 0;
            }
            else{
                carry = 1;
                insertEnd(curr_sum%10);
            }
        }
        if(carry!=0)
            insertEnd(carry);
        return res;
    }

    void insertEnd(int data){
        Node temp = new Node(data);
        if(res == null){
            res = temp;
        }
        else{
            last.next = temp;
        }
        last = temp;
    }
}