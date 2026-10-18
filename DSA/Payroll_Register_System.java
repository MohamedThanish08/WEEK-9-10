import java.util.*;

abstract class Staff {
    String name, type;

    Staff(String name, String type) {
        this.name = name;
        this.type = type;
    }

    abstract long calculatePay();

    public String toString() {
        return "Payslip[name=" + name
                + ", type=" + type
                + ", pay=" + calculatePay() + "]";
    }
}

class FullTime extends Staff {
    long salary;

    FullTime(String name, long salary) {
        super(name, "FullTime");
        this.salary = salary;
    }

    long calculatePay() {
        return salary;
    }
}

class PartTime extends Staff {
    long hours, rate;

    PartTime(String name, long hours, long rate) {
        super(name, "PartTime");
        this.hours = hours;
        this.rate = rate;
    }

    long calculatePay() {
        return hours * rate;
    }
}

class Intern extends Staff {
    long stipend;

    Intern(String name, long stipend) {
        super(name, "Intern");
        this.stipend = stipend;
    }

    long calculatePay() {
        return stipend;
    }
}

public class Payroll_Register_System {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Staff> staffList = new ArrayList<>();

        while (sc.hasNext()) {
            String type = sc.next();
            String name = sc.next();

            switch (type) {
                case "FullTime":
                    staffList.add(
                            new FullTime(name, sc.nextLong()));
                    break;

                case "PartTime":
                    staffList.add(new PartTime(
                            name, sc.nextLong(), sc.nextLong()));
                    break;

                case "Intern":
                    staffList.add(
                            new Intern(name, sc.nextLong()));
                    break;
            }
        }

        long total = 0;
        Staff topEarner = null;

        for (Staff s : staffList) {
            System.out.println(s);
            total += s.calculatePay();

            if (topEarner == null ||
                    s.calculatePay() > topEarner.calculatePay()) {
                topEarner = s;
            }
        }

        System.out.println("Total " + total);

        if (topEarner != null)
            System.out.println("top earner " + topEarner.name);

        sc.close();
    }
}
