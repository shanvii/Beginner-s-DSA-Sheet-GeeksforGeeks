//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next, prev;

    Node(int key) {
        data = key;
        next = prev = null;
    }
}

class Driverclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;

            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                Node n1 = new Node(a);
                n1.prev = temp;
                temp.next = n1;
                temp = n1;
            }

            head = new Solution().sortDoubly(head);
            printList(head);
        }
    }

    public static void printList(Node node) {
        Node temp = node;
        while (node != null) {
            System.out.print(node.data + " ");
            temp = node;
            node = node.next;
        }
        System.out.println();
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

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
class Solution {
    static Node merge(Node h1, Node h2){
        Node temp =new Node(-1);
        Node head=temp;
        
        while(h1!=null && h2!=null){
            if(h1.data<h2.data){
                temp.next=h1;
                h1.prev=temp;
                h1=h1.next;
            }
            else{
                temp.next=h2;
                h2.prev=temp;
                h2=h2.next;
            }
            temp=temp.next;
        }
        while(h1!=null){
            temp.next=h1;
            h1.prev=temp;
            h1=h1.next;
            temp=temp.next;
        }
        while(h2!=null){
            temp.next=h2;
            h2.prev=temp;
            h2=h2.next;
            temp=temp.next;
        }
        head.next.prev=null;
        return head.next;
    }
    
    static Node sortDoubly(Node head) {
        if(head.next == null){
            return head;
        }
        Node mid =findmid(head);
        Node head2=mid.next;
        mid.next=null;
        mid.prev=null;
        
        Node left =sortDoubly(head);
        Node right =sortDoubly(head2);
        
        Node ans = merge(left,right);
        
        return ans;
        
    }
    
    static Node findmid(Node head){
        Node slow=head;
        Node fast=head.next;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}