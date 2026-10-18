import java.util.*;

class Student {
    String rollNumber, name;

    Student(String rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;

        Student s = (Student) obj;
        return rollNumber.equals(s.rollNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNumber);
    }
}

public class Student_Club_Registration_Management {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Student> members = new HashSet<>();
        List<String> results = new ArrayList<>();

        while (sc.hasNext()) {
            String op = sc.next();
            String roll = sc.next();
            String name = sc.next();

            Student s = new Student(roll, name);

            if (op.equals("ADD")) {
                if (members.add(s))
                    System.out.println("Added");
                else
                    System.out.println("duplicate rejected");

            } else if (op.equals("CONTAINS")) {
                results.add("contains: " + members.contains(s));
            }
        }

        System.out.println("member count " + members.size());

        for (String result : results)
            System.out.println(result);

        sc.close();
    }
}
