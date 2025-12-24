public class Vehicles {
    private VehicleNode head;
    private VehicleNode current;

    public Vehicles() {
        head = null;
        current = null;
    }

    public void add(Vehicle v) {
        VehicleNode newNode = new VehicleNode(v);
        newNode.next = head;
        head = newNode;
    }

    public Vehicle getVehicle(String vin) throws Exception {
        VehicleNode temp = head;
        while (temp != null) {
            if (temp.vehicle.getVIN().equals(vin)) return temp.vehicle;
            temp = temp.next;
        }
        throw new Exception("Vehicle not found");
    }

    public void reset() { current = head; }
    public boolean hasNext() { return current != null; }
    public Vehicle getNext() {
        Vehicle v = current.vehicle;
        current = current.next;
        return v;
    }
}