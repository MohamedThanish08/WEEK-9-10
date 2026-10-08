import java.util.*;

public class prblm4 {

    static int countAlerts(
            int[] readings,
            int k,
            int threshold) {

        int count = 0;
        int windowSum = 0;

        // First window
        for (int i = 0; i < k; i++) {
            windowSum += readings[i];
        }

        if (windowSum >= k * threshold) {
            count++;
        }

        // Slide the window
        for (int i = k; i < readings.length; i++) {

            windowSum += readings[i];
            windowSum -= readings[i - k];

            if (windowSum >= k * threshold) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of readings: ");
        int n = sc.nextInt();

        int[] readings = new int[n];

        System.out.println("Enter temperature readings:");

        for (int i = 0; i < n; i++) {
            readings[i] = sc.nextInt();
        }

        System.out.print("Enter block size k: ");
        int k = sc.nextInt();

        System.out.print("Enter threshold: ");
        int threshold = sc.nextInt();

        int result = countAlerts(readings, k, threshold);

        System.out.println("Number of alert windows: " + result);

        sc.close();
    }
}