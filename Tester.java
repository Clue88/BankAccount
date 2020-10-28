public class Tester {
    public static void main(String[] args) {
        int err = 0;
        BankAccount x = new BankAccount(123456, "test123");
        BankAccount y = new BankAccount(69, "hello");

        err += check("x.toString()", x.toString(), "#123456\t$0.0");
        err += check("x.deposit(12)", x.deposit(12), true);
        err += check("x.getBalance()", x.getBalance(), 12.0);
        err += check("x.toString()", x.toString(), "#123456\t$12.0");
        err += check("x.getAccountID", x.getAccountID(), 123456);
        err += check("x.deposit(-12)", x.deposit(-12), false);
        err += check("x.withdraw(5)", x.withdraw(5), true);
        err += check("x.withdraw(-2)", x.withdraw(-2), false);
        err += check("x.withhdraw(100)", x.withdraw(100), false);
        err += check("x.getBalance()", x.getBalance(), 7.0);
        err += check("x.transferTo(y, 1, \"test123\"", x.transferTo(y, 1, "test123"), true);
        err += check("x.getBalance()", x.getBalance(), 6.0);
        err += check("y.getBalance()", y.getBalance(), 1.0);
        err += check("y.transferTo(x, 2, \"hello\"", x.transferTo(x, 2, "hello"), false);
        err += check("x.getBalance()", x.getBalance(), 6.0);
        err += check("y.getBalance()", y.getBalance(), 1.0);
        
        // There's no way to check the password, so I'll use a try/catch to
        // see if it fails somehow.
        try {
            x.setPassword("new!");
        } catch (Exception e) {
            err += 1;
            System.out.println("Failure on x.setPassword: Crashed.");
        }

        if (err == 0) System.out.println("All good!");
        else if (err == 1) System.out.println("Uh oh... 1 error found.");
        else System.out.println("Uh oh... " + err + " errors found.");
    }

    public static int check(String name, Object actual, Object expected) {
        if (actual.equals(expected)) return 0;
        else {
            System.out.println("Failure on " + name + ": Expected \"" +
                                expected + "\", got \"" + actual + "\".");
            return 1;
        }
    }
}
