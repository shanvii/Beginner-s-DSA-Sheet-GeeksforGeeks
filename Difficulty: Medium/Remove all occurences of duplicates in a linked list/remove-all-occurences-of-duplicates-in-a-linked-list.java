//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GFG {
    Node head;
    Node tail;

    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            GFG llist = new GFG();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < N; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }

            Solution ob = new Solution();
            head = ob.removeAllDuplicates(llist.head);
            llist.printList(head);

            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    public Node removeAllDuplicates(Node head) {
        // code here
        Node current = head;
        Node previous = head;
        if(head == null){
            return null;
        }
        
        if(head.next == null){
            return head;
        }
        
        while(current != null && current.next != null){
            Node nextt = current.next;
            
            if(current.data != nextt.data){
                previous = current;
                current = nextt;
                
            }
            
            else{
                int value = current.data;
                if(current == head){
                    while(head != null && head.data == value){
                        head = head.next;
                    }
                    previous = head;
                    current = head;
                }
                else{
                    while(current != null && current.data == value){
                        current = current.next;
                    }
                    previous.next = current;
                }
            }
        }
        
        return head;
    }
}