public class TimePeriod {
    private char unit;   // 'd', 'w', 'm'
    private int quantity;

    public TimePeriod(char unit, int quantity) {
        this.unit = unit;
        this.quantity = quantity;
    }

    public char getUnit() { return unit; }
    public int getQuantity() { return quantity; }

    public String toString() {
        return quantity + " " + (unit == 'd' ? "days" : unit == 'w' ? "weeks" : "months");
    }
}