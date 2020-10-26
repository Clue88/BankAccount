public class Tester {
    public static void main(String[] args) {
        boolean allGood = true;
        BankAccount x = new BankAccount(219291, "test123");

        allGood = check("x.toString()", x.toString(), "219291\t0.0");

        if (allGood) System.out.println("All good!");
    }

    public static boolean check(String name, String actual, String expected) {
        if (actual.equals(expected)) return true;
        else {
            System.out.println("Failure on " + name + ": Expected \"" + expected + "\", got \"" + actual + "\".");
            return false;
        }
    }
}
