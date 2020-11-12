package new_package;

import java.util.Date;

abstract class Medicine {
    double price;
    String Dae;

    public abstract void getDetails();

    public abstract void displayLabel();
}

class Tablet extends Medicine {

    @Override
    public void getDetails() {

    }

    @Override
    public void displayLabel() {
        System.out.println("Take Prescription from doctor Before usage");
    }
}

class Syrup extends Medicine {

    @Override
    public void getDetails() {

    }

    @Override
    public void displayLabel() {
        System.out.println("Place in Dry place");
    }
}

class Ointment extends Medicine {

    @Override
    public void getDetails() {

    }

    @Override
    public void displayLabel() {
        System.out.println("for External use only");
    }
}

public class TestMedicine {
    public static void main(String[] args) {
        Medicine[] medicine = new Medicine[5];
        for (int i = 0; i < 5; i++) {
            int choice = 1 + (int) (Math.random() * 1000) % 3;
            switch (choice) {
                case 1:
                    medicine[i] = new Tablet();
                    System.out.println("tablet");
                    break;
                case 2:
                    medicine[i] = new Syrup();
                    System.out.println("syrup");
                    break;
                case 3:
                    medicine[i] = new Ointment();
                    System.out.println("ointment");
                    break;

            }
        }
        for (int i = 0; i < 5; i++) {
            medicine[i].displayLabel();
        }
    }
}
