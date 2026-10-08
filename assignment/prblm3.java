import java.util.*;

public class prblm3 {

    static String[] mostPopular(ArrayList<String> orders) {

        HashMap<String, Integer> frequency = new HashMap<>();

        for (String item : orders) {
            frequency.put(item, frequency.getOrDefault(item, 0) + 1);
        }

        String popularItem = orders.get(0);
        int maxCount = frequency.get(popularItem);

        for (String item : orders) {
            int count = frequency.get(item);

            if (count > maxCount) {
                maxCount = count;
                popularItem = item;
            }
        }

        return new String[]{
            popularItem,
            String.valueOf(maxCount)
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of orders: ");
        int n = sc.nextInt();

        ArrayList<String> orders = new ArrayList<>();

        System.out.println("Enter order names:");

        for (int i = 0; i < n; i++) {
            orders.add(sc.next());
        }

        String[] result = mostPopular(orders);

        System.out.println("Most popular item: " + result[0]);
        System.out.println("Number of orders: " + result[1]);

        sc.close();
    }
}