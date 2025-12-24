public class TransactionTestDriver {
    public static void main(String[] args) {
        Transactions transactions = new Transactions();

        Transaction t1 = new Transaction("3212546453245879", "Marvin Ampofo", "Car: Toyota Prius", "3 days", "540", "120.54");
        Transaction t2 = new Transaction("7890123456789012", "Peter Parker", "SUV: Ford Explorer", "1 week", "380", "245.95");

        transactions.add(t1);
        transactions.add(t2);

        System.out.println("--- TRANSACTIONS ---");
        transactions.reset();
        while (transactions.hasNext()) {
            System.out.println(transactions.getNext());
        }
    }
}
