import java.util.*;

public class prblm2 {

    static ArrayList<Integer> mergeTokens(
            ArrayList<Integer> counterA,
            ArrayList<Integer> counterB) {

        ArrayList<Integer> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < counterA.size() && j < counterB.size()) {

            if (counterA.get(i) <= counterB.get(j)) {
                result.add(counterA.get(i));
                i++;
            } else {
                result.add(counterB.get(j));
                j++;
            }
        }

        while (i < counterA.size()) {
            result.add(counterA.get(i));
            i++;
        }

        while (j < counterB.size()) {
            result.add(counterB.get(j));
            j++;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of tokens in Counter A: ");
        int m = sc.nextInt();

        ArrayList<Integer> counterA = new ArrayList<>();

        System.out.println("Enter sorted tokens for Counter A:");
        for (int i = 0; i < m; i++) {
            counterA.add(sc.nextInt());
        }

        System.out.print("Enter number of tokens in Counter B: ");
        int n = sc.nextInt();

        ArrayList<Integer> counterB = new ArrayList<>();

        System.out.println("Enter sorted tokens for Counter B:");
        for (int i = 0; i < n; i++) {
            counterB.add(sc.nextInt());
        }

        ArrayList<Integer> result = mergeTokens(counterA, counterB);

        System.out.println("Merged list: " + result);

        sc.close();
    }
}