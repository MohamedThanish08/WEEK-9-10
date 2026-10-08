import java.util.*;

public class prblm5 {

    static int findSlot(int[] prices, int newPrice) {

        int low = 0;
        int high = prices.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (prices[mid] == newPrice) {
                return mid;
            } 
            else if (prices[mid] < newPrice) {
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of prices: ");
        int n = sc.nextInt();

        int[] prices = new int[n];

        System.out.println("Enter prices in sorted order:");

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        System.out.print("Enter new price: ");
        int newPrice = sc.nextInt();

        int result = findSlot(prices, newPrice);

        System.out.println("Price should be at index: " + result);

        sc.close();
    }
}