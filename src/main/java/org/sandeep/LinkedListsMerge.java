package org.sandeep;

/**
 * Created by sandeep.samudrala on 3/25/16.
 */
public class LinkedListsMerge {
    Node head;  // head of list
    static Node a, b;

    /* Node Class */
    static class Node {

        int data;
        Node next;

        // Constructor to create a new node
        Node(int d) {
            data = d;
            next = null;
        }
    }

    void printlist(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }



    public static void main(String[] args) {

        LinkedListsMerge list = new LinkedListsMerge();
        Node result = null;

        /*Let us create two sorted linked lists to test
         the above functions. Created lists shall be
         a: 5->10->15
         b: 2->3->20*/
        list.a = new Node(5);
        list.a.next = new Node(10);
        list.a.next.next = new Node(15);

        list.b = new Node(2);
        list.b.next = new Node(3);
        list.b.next.next = new Node(20);

        System.out.println("List a before merge :");
        list.printlist(a);
        System.out.println("");
        System.out.println("List b before merge :");
        list.printlist(b);

        // merge two sorted linkedlist in decreasing order
        result = list.sortedmerge(a, b);
        System.out.println("");
        System.out.println("Merged linked list : ");
        list.printlist(result);

    }

    private Node sortedmerge(Node a, Node b) {
        if (a == null && b == null) {
            return null;
        }
        Node res = null;
        while (a != null && b != null) {
            if (a.data <= b.data) {
                Node temp = a.next;
                a.next = res;
                res = a;
                a = temp;
            } else {
                Node temp = b;
                b.next = res;
                res = b;
                b = temp;
            }
        }
        while (a != null) {
            Node temp = a.next;
            a.next = res;
            res = a;
            a = temp;
        }
        while (b != null) {
            Node temp = b.next;
            b.next = res;
            res = b;
            b = temp;
        }
        return res;
    }
}
