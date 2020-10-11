class Account {
    private String name;
    private int accNO;
    private double amount;

    public void withdraw(double amount) {
        if (this.amount - amount < 0) {
            System.out.println("Transaction Declined Due to low amount");
        } else {
            this.amount -= amount;
            System.out.println("Transcation complete Balance "+this.amount);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccNO() {
        return accNO;
    }

    public void setAccNO(int accNO) {
        this.accNO = accNO;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Account(String name, int accNO, double amount) {
        this.name = name;
        this.accNO = accNO;
        this.amount = amount;
    }

}

class AccountThread implements Runnable {
    Account a;
double amount;
    public AccountThread(Account a,double amount) {
        this.a = a;
        this.amount=amount;
    }

    @Override
    public  synchronized void run() {
        //System.out.println(Thread.currentThread().getName());
        a.withdraw(amount);
        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class AccountDriver {
    public static void main(String[] args) {
        Account a = new Account("rashwin", 12345, 3500);
        AccountThread a1 = new AccountThread(a,1500);
        AccountThread a2=new AccountThread(a,2000);
        Thread t1 = new Thread(a1, "Transaction1");
        Thread t2 = new Thread(a2, "Transaction2");
        t1.start();
        t2.start();
    }
}
