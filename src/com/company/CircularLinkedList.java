package com.company;

public class CircularLinkedList {

    int size = 0;

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node head = null;
    public Node tail = null;


    /**
     * The code below adds a circular LinkedList in order to get checked
     * @param data
     */

    public void add(int data) {
        //Create new node
        Node newNode = new Node(data);
        //Checks if the list is empty.
        if (head == null) {
            //If list is empty, both head and tail would point to new node.
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            //tail will point to new node.
            tail.next = newNode;
            //New node will become new tail.
            tail = newNode;
            //Since, it is circular linked list tail will point to head.
            tail.next = head;
        }
        size++;
    }

    public void display() {
        Node current = head;
        if(head == null) {
            System.out.println("List is empty");
        }
        else {
            System.out.println("Nodes of the circular linked list: ");
            do{
                //Prints each node by incrementing pointer.
                System.out.print(" "+ current.data);
                current = current.next;
            } while(current != head);
            System.out.println();
        }
    }


    public int check() {

        Node fast = head;
        Node slow = head;

        int counter = 0;
        while (fast!= null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;
            counter++;

            if (counter == size) {
                counter = 0;
            }

            if (fast == slow) {
                return counter;
            }

        }
        return -1;
    }


    public static void main(String[] args) {
        CircularLinkedList cl = new CircularLinkedList();
        //Adds data to the list
        cl.add(1);
        cl.add(2);
        cl.add(3);
        cl.add(4);
        //Displays all the nodes present in the list
        System.out.print("Testing -- ");
        cl.display();

        System.out.println("Circular LinkedList Match at Index " + cl.check());
    }
}