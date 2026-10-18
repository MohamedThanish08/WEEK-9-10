
import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RoundRobinGameTurns {

    static Node head = null;
    static Node tail = null;

    static void addPlayer(int player) {
        Node newNode = new Node(player);

        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    static void displayPlayers() {
        if (head == null) {
            System.out.println("No players in the game.");
            return;
        }

        Node current = head;

        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);

        System.out.println("(back to start)");
    }

    static void playTurns(int rounds) {
        if (head == null) {
            System.out.println("No players in the game.");
            return;
        }

        Node current = head;

        for (int i = 1; i <= rounds; i++) {
            System.out.println(
                "Round " + i + ": Player " + current.data + "'s turn"
            );
            current = current.next;
        }
    }

    static void removePlayer(int player) {
        if (head == null) {
            System.out.println("No players in the game.");
            return;
        }

        Node current = head;
        Node previous = tail;

        do {
            if (current.data == player) {
                if (head == tail) {
                    head = tail = null;
                } else {
                    previous.next = current.next;

                    if (current == head) {
                        head = current.next;
                    }

                    if (current == tail) {
                        tail = previous;
                    }

                    tail.next = head;
                }

                System.out.println("Player " + player + " removed.");
                return;
            }

            previous = current;
            current = current.next;

        } while (current != head);

        System.out.println("Player not found.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice, player, rounds;

        do {
            System.out.println("\n--- Round Robin Game Turns ---");
            System.out.println("1. Add player");
            System.out.println("2. Display players");
            System.out.println("3. Play turns");
            System.out.println("4. Remove player");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter player number: ");
                    player = sc.nextInt();
                    addPlayer(player);
                    break;

                case 2:
                    displayPlayers();
                    break;

                case 3:
                    System.out.print("Enter number of turns: ");
                    rounds = sc.nextInt();

                    if (rounds < 0) {
                        System.out.println("Turns cannot be negative.");
                    } else {
                        playTurns(rounds);
                    }
                    break;

                case 4:
                    System.out.print("Enter player number to remove: ");
                    player = sc.nextInt();
                    removePlayer(player);
                    break;

                case 0:
                    System.out.println("Exiting game.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}
