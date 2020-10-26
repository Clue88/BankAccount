public class BankAccount {
    private double balance;
    private int accountID;
    private String password;

    public BankAccount(int id, String pass) {
        balance = 0;
        accountID = id;
        password = pass;
    }

    public double getBalance() {
        return balance;
    }

    public int getID() {
        return accountID;
    }

    public void setPassword(String pass) {
        password = pass;
    }

    public boolean deposit(double amount) {
        if (amount < 0) return false;
        else {
            balance += amount;
            return true;
        }
    }
}
