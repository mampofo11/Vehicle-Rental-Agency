import java.util.ArrayList;

public class Transactions {
    private ArrayList<Transaction> history = new ArrayList<>();
    private int currentIndex = 0;

    public void add(Transaction t) {
        history.add(t);
    }

    public void reset() {
        currentIndex = 0;
    }

    public boolean hasNext() {
        return currentIndex < history.size();
    }

    public Transaction getNext() {
        return history.get(currentIndex++);
    }
}