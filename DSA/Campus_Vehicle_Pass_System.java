import java.util.*;

interface Chargeable {
    void charge();
}

class Vehicle {
    String passNumber, owner, type;

    Vehicle(String passNumber, String owner, String type) {
        this.passNumber = passNumber;
        this.owner = owner;
        this.type = type;
    }

    int getFee() {
        return (type.equals("Bike") || type.equals("EBike"))
                ? 300 : 1000;
    }
}

class Bike extends Vehicle {
    Bike(String p, String o) {
        super(p, o, "Bike");
    }
}

class Car extends Vehicle {
    Car(String p, String o) {
        super(p, o, "Car");
    }
}

class EBike extends Vehicle implements Chargeable {
    EBike(String p, String o) {
        super(p, o, "EBike");
    }

    public void charge() {
        System.out.println(passNumber + " charging bay allotted");
    }
}

class ECar extends Vehicle implements Chargeable {
    ECar(String p, String o) {
        super(p, o, "ECar");
    }

    public void charge() {
        System.out.println(passNumber + " charging bay allotted");
    }
}

public class Campus_Vehicle_Pass_System {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Vehicle> vehicles = new HashMap<>();

        while (sc.hasNext()) {
            String op = sc.next();

            if (op.equals("PASS")) {
                String type = sc.next();
                String pass = sc.next();
                String owner = sc.next();

                Vehicle v;

                switch (type) {
                    case "Bike":
                        v = new Bike(pass, owner);
                        break;
                    case "Car":
                        v = new Car(pass, owner);
                        break;
                    case "EBike":
                        v = new EBike(pass, owner);
                        break;
                    case "ECar":
                        v = new ECar(pass, owner);
                        break;
                    default:
                        continue;
                }

                vehicles.put(pass, v);
                System.out.println(pass + " (" + type
                        + ") pass fee " + v.getFee());

            } else if (op.equals("CHARGE")) {
                String pass = sc.next();
                Vehicle v = vehicles.get(pass);

                if (v == null) {
                    System.out.println("Vehicle not found");
                } else if (v instanceof Chargeable) {
                    ((Chargeable) v).charge();
                } else {
                    System.out.println(pass
                            + " rejected: charging unsupported");
                }
            }
        }
        sc.close();
    }
}