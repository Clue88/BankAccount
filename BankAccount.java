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

    public int getAccountID() {
        return accountID;
    }

    public void setPassword(String newPass) {
        password = newPass;
    }

    public boolean deposit(double amount) {
        if (amount < 0) return false;
        else {
            balance += amount;
            return true;
        }
    }

    public boolean withdraw(double amount) {
        if (amount < 0) return false;
        if (amount > balance) return false;
        balance -= amount;
        return true;
    }
}
