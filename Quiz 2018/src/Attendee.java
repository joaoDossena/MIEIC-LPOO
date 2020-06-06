public class Attendee extends Person {
    private boolean paid = false;

    public Attendee(String name) { super(name); }
    public Attendee(String name, int age) { super(name, age); }

    public boolean hasPaid() { return this.paid; }

    @Override
    public String toString() { return "Attendee " + this.name + (this.paid ? " has" : " hasn't") + " paid its registration."; }




}
