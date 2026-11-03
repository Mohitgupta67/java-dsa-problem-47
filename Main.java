public class Main {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node rotateRight(Node head, int k) {

        
        if (head == null || head.next == null || k == 0) {
            return head;
        }

       
        int length = 1;
        Node tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

      
        k = k % length;

        if (k == 0) {
            return head;
        }

        
        tail.next = head;

       
        int steps = length - k - 1;
        Node newTail = head;

        for (int i = 0; i < steps; i++) {
            newTail = newTail.next;
        }

       
        Node newHead = newTail.next;

        
        newTail.next = null;

        return newHead;
    }

    
    public static void printList(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int k = 3;

        System.out.println("Original Linked List:");
        printList(head);

        head = rotateRight(head, k);

        System.out.println("After Right Rotation:");
        printList(head);
    }
}