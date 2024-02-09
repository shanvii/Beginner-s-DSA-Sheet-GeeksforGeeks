//{ Driver Code Starts
import java.util.Scanner;
import java.math.*;

// Node Class
class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

// Linked List Class
class LinkedList {
    Node head;
    Node tail;

    LinkedList() {
        head = null;
        tail = null;
    }

    // creates a new node with given value and appends it at the end of the linked list
    void insert(int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
        } else {
            tail.next = new Node(val);
            tail = tail.next;
        }
    }
}


public class Main {
    static void printList(Node n) 
    {
        while (n != null) {
            System.out.print(n.data);
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; ++i) {
            int n = sc.nextInt();
            LinkedList LL1 = new LinkedList();
            String l1 = sc.next();
            for (int j = 0; j < n; ++j) {
                int x = Character.getNumericValue(l1.charAt(j));
                LL1.insert(x);
            }

            int m = sc.nextInt();
            LinkedList LL2 = new LinkedList();
            String l2 = sc.next();
            for (int j = 0; j < m; ++j) {
                int x = Character.getNumericValue(l2.charAt(j));
                LL2.insert(x);
            }

            Solution ob = new Solution();
            Node res = ob.subLinkedList(LL1.head, LL2.head);
            printList(res);
        }
    }
}

// } Driver Code Ends




/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/



/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    int length(Node n){
        int result = 0;
        while(n != null){
            result++;
            n = n.next;
        }
        return result;
    }
    
    Node reverse(Node head){
        Node previous = null;
        Node current = head;
        Node next = null;
        
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
    
    public Node subLinkedList(Node head1, Node head2) {
        while(head1 != null && head1.data == 0){
            head1 = head1.next;
        }
        
        while(head2 != null && head2.data == 0){
            head2 = head2.next;
        }
        
        int n1 = length(head1);
        int n2 = length(head2);
        
        if(n1 == 0 && n2 == 0){
            return new Node(0);
        }
        
        if(n2 > n1){
            Node temp = head1;
            head1 = head2;
            head2 = temp;
        }
        
        if(n1 == n2){
            Node temp1 = head1;
            Node temp2 = head2;
            while(temp1.data == temp2.data){
                temp1 = temp1.next;
                temp2 = temp2.next;
                
                if(temp1 == null){
                    return new Node(0);
                }
            }
            
            if(temp2.data > temp1.data){
                Node temp = head1;
                head1 = head2;
                head2 = temp;
            }
        }
        
        head1 = reverse(head1);
        head2 = reverse(head2);
        Node ans = null;
        
        Node temp1 = head1;
        Node temp2 = head2;
        while(temp1 != null){
            int less = 0;
            if(temp2 != null){
                less = temp2.data;
            }
            
            if(temp1.data < less){
                if(temp1.next != null){
                    temp1.next.data -= 1;
                }
                temp1.data += 10;
            }
            Node nd = new Node(temp1.data - less);
            nd.next = ans;
            ans = nd;
            temp1 = temp1.next;
            
            if(temp2 != null){
                temp2 = temp2.next;
            }
        }
        
        while(ans != null && ans.next != null && ans.data == 0){
            ans = ans.next;
        }
        return ans;
    }
}
        