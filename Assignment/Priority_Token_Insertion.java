
import java.util.Scanner;

public class Priority_Token_Insertion {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        Node head;

        // Add a token at the beginning
        void addFirst(int token) {
            Node newNode = new Node(token);
            newNode.next = head;
            head = newNode;
        }

        // Add a token at the end
        void addLast(int token) {
            Node newNode = new Node(token);

            if (head == null) {
                head = newNode;
                return;
            }

            Node current = head;
            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        // Insert a token at a given 0-based index
        void insertAt(int index, int token) {
            if (index == 0) {
                addFirst(token);
                return;
            }

            Node current = head;

            // Move to the node just before the index
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            Node newNode = new Node(token);
            newNode.next = current.next;
            current.next = newNode;
        }

        // Print the list
        void display() {
            Node current = head;

            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }

            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();

        // Input starting list
        System.out.print("Enter number of starting tokens: ");
        int n = sc.nextInt();

        System.out.println("Enter starting tokens:");
        for (int i = 0; i < n; i++) {
            list.addLast(sc.nextInt());
        }

        // Input operations
        System.out.print("Enter number of operations: ");
        int operations = sc.nextInt();

        System.out.println(
            "Operations: 1 = addFirst, 2 = addLast, 3 = insertAt"
        );

        for (int i = 0; i < operations; i++) {
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    int firstToken = sc.nextInt();
                    list.addFirst(firstToken);
                    break;

                case 2:
                    int lastToken = sc.nextInt();
                    list.addLast(lastToken);
                    break;

                case 3:
                    int index = sc.nextInt();
                    int token = sc.nextInt();
                    list.insertAt(index, token);
                    break;

                default:
                    System.out.println("Invalid operation");
            }
        }

        System.out.println("Final list:");
        list.display();

        sc.close();
    }
}
