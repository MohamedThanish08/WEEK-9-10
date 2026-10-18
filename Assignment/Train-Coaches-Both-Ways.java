
import java.util.Scanner;

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class TrainCoachesBothWays {
    static Node head = null;
    static Node tail = null;

    static void insertBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    static void insertEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    static void insertPosition(int data, int position) {
        if (position <= 1 || head == null) {
            insertBeginning(data);
            return;
        }

        Node current = head;
        int count = 1;

        while (current.next != null && count < position - 1) {
            current = current.next;
            count++;
        }

        if (current == tail) {
            insertEnd(data);
            return;
        }

        Node newNode = new Node(data);
        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;
    }

    static void deleteBeginning() {
        if (head == null) {
            System.out.println("Train is empty.");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    static void deleteEnd() {
        if (tail == null) {
            System.out.println("Train is empty.");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    static void deletePosition(int position) {
        if (head == null || position < 1) {
            System.out.println("Invalid position or empty train.");
            return;
        }

        if (position == 1) {
            deleteBeginning();
            return;
        }

        Node current = head;
        int count = 1;

        while (current != null && count < position) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Invalid position.");
            return;
        }

        if (current == tail) {
            deleteEnd();
            return;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
    }

    static void search(int data) {
        Node current = head;
        int position = 1;

        while (current != null) {
            if (current.data == data) {
                System.out.println(
                    "Coach found at position " + position
                );
                return;
            }

            current = current.next;
            position++;
        }

        System.out.println("Coach not found.");
    }

    static void displayForward() {
        if (head == null) {
            System.out.println("Train is empty.");
            return;
        }

        Node current = head;

        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }

        System.out.println("null");
    }

    static void displayBackward() {
        if (tail == null) {
            System.out.println("Train is empty.");
            return;
        }

        Node current = tail;

        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice, data, position;

        do {
            System.out.println("\n--- Train Coaches Both Ways ---");
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert at position");
            System.out.println("4. Delete from beginning");
            System.out.println("5. Delete from end");
            System.out.println("6. Delete from position");
            System.out.println("7. Search coach");
            System.out.println("8. Display forward");
            System.out.println("9. Display backward");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter coach number: ");
                    data = sc.nextInt();
                    insertBeginning(data);
                    break;

                case 2:
                    System.out.print("Enter coach number: ");
                    data = sc.nextInt();
                    insertEnd(data);
                    break;

                case 3:
                    System.out.print("Enter coach number: ");
                    data = sc.nextInt();
                    System.out.print("Enter position: ");
                    position = sc.nextInt();
                    insertPosition(data, position);
                    break;

                case 4:
                    deleteBeginning();
                    break;

                case 5:
                    deleteEnd();
                    break;

                case 6:
                    System.out.print("Enter position: ");
                    position = sc.nextInt();
                    deletePosition(position);
                    break;

                case 7:
                    System.out.print("Enter coach number to search: ");
                    data = sc.nextInt();
                    search(data);
                    break;

                case 8:
                    displayForward();
                    break;

                case 9:
                    displayBackward();
                    break;

                case 0:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}

