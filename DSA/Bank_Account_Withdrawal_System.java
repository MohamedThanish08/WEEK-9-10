import java.util.*;

class Account {
    String id;
    double balance;

    Account(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    String format(double n) {
        return n == (long)n
                ? String.valueOf((long)n)
                : String.valueOf(n);
    }

    String withdraw(double amount) {
        return "";
    }
}

class Savings extends Account {
    Savings(String id, double balance) {
        super(id, balance);
    }

    @Override
    String withdraw(double amount) {
        if (balance - amount < 1000)
            return id + " rejected: minimum balance 1000";

        balance -= amount;
        return id + " balance " + format(balance);
    }
}

class Current extends Account {
    Current(String id, double balance) {
        super(id, balance);
    }

    @Override
    String withdraw(double amount) {
        if (balance - amount < -5000)
            return id + " rejected: overdraft limit 5000";

        balance -= amount;
        return id + " balance " + format(balance);
    }
}

public class Bank_Account_Withdrawal_System {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Account> accounts = new HashMap<>();

        while (sc.hasNext()) {
            String op = sc.next();

            if (op.equals("Savings")) {
                String id = sc.next();
                double balance = sc.nextDouble();
                accounts.put(id, new Savings(id, balance));

            } else if (op.equals("Current")) {
                String id = sc.next();
                double balance = sc.nextDouble();
                accounts.put(id, new Current(id, balance));

            } else if (op.equals("WITHDRAW")) {
                String id = sc.next();
                double amount = sc.nextDouble();
                Account a = accounts.get(id);

                if (a == null)
                    System.out.println("Account not found");
                else
                    System.out.println(a.withdraw(amount));
            }
        }
        sc.close();
    }
}