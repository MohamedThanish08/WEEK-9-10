import java.util.*;

public class Problem1 {

    static String findBook(String[] isbn, String[] title, String targetIsbn) {
        int left = 0;
        int right = isbn.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int comparison = isbn[mid].compareTo(targetIsbn);

            if (comparison == 0) {
                return title[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] isbn = new String[n];
        String[] title = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter ISBN: ");
            isbn[i] = sc.nextLine();

            System.out.print("Enter title: ");
            title[i] = sc.nextLine();
        }

        System.out.print("Enter ISBN to search: ");
        String target = sc.nextLine();

        System.out.println("Result: " + findBook(isbn, title, target));

        sc.close();
    }
}