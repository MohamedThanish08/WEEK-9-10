import java.util.*;

public class Class_Marks_Grid_Analysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> names = new ArrayList<>();
        List<int[]> marksList = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();

            if (line.isEmpty()) continue;

            int start = line.indexOf('[');
            int end = line.indexOf(']');

            if (start == -1 || end == -1) continue;

            String name = line.substring(0, start).trim();
            String[] values = line.substring(start + 1, end)
                    .split(",");

            if (values.length != 3) continue;

            int[] marks = new int[3];

            for (int i = 0; i < 3; i++)
                marks[i] = Integer.parseInt(values[i].trim());

            names.add(name);
            marksList.add(marks);
        }

        if (names.isEmpty()) {
            sc.close();
            return;
        }

        int[] subjectTotals = new int[3];
        int[] totals = new int[names.size()];
        int topper = 0;

        System.out.print("Totals ");

        for (int i = 0; i < names.size(); i++) {
            int[] marks = marksList.get(i);

            for (int j = 0; j < 3; j++) {
                totals[i] += marks[j];
                subjectTotals[j] += marks[j];
            }

            if (totals[i] > totals[topper])
                topper = i;

            if (i > 0) System.out.print(", ");

            System.out.print(names.get(i) + " " + totals[i]);
        }

        System.out.println();

        System.out.printf(Locale.US,
                "averages %.2f, %.2f, %.2f%n",
                subjectTotals[0] / (double) names.size(),
                subjectTotals[1] / (double) names.size(),
                subjectTotals[2] / (double) names.size());

        System.out.println("topper " + names.get(topper)
                + " (" + totals[topper] + ")");

        sc.close();
    }
}
