/**
 * Visitor class extends Person, representing guests at the theme park.
 * Adds attributes for ticket type and VIP status.
 */
public class Visitor extends Person {
    private String ticketType; // e.g., Unlimited, Standard
    private boolean isVip;     // VIP status

    public Visitor() {
        super();
        this.ticketType = "Standard";
        this.isVip = false;
    }

    public Visitor(String id, String name, int age, String mobileNumber, String ticketType, boolean isVip) {
        super(id, name, age, mobileNumber);
        this.ticketType = ticketType;
        this.isVip = isVip;
    }

    public String getTicketType() { return ticketType; }
    public void setTicketType(String ticketType) { this.ticketType = ticketType; }

    public boolean isVip() { return isVip; }
    public void setVip(boolean vip) { isVip = vip; }

    @Override
    public String toString() {
        return "[Visitor]  " + super.toString() + " | Ticket: " + ticketType + " | VIP: " + (isVip ? "Yes" : "No");
    }
}