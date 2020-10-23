package com.company;

/**
 * Checks if a LinkedList is Circular and returns the index where it starts
 */
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
     * adds the nodes to the LinkedList
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

    /**
     * displays the LinkedList
     */
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


    /**
     * Takes in the sample input that main calls, and checks if it is circular
     * @return
     */
    public int check() {
        Node fast = head;
        Node slow = head;

        int counter = 0;
        while (fast!= null && fast.next != null) {

            fast = fast.next.next;          // fast node is incrementing faster than the slow node
            slow = slow.next;
            counter++;

            if (counter == size) {          // want to reset the counter
                counter = 0;
            }

            if (fast == slow) {
                return counter;
            }

        }
        return -1;
    }

    /**
     * Calls all of the above function
     * @param args
     */
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