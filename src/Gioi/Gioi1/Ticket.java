package Gioi.Gioi1;


public class Ticket {
    private String ticketId;
    private String roomName;
    private boolean sold;
    private boolean isNew;

    public Ticket(String ticketId, String roomName, boolean isNew) {
        this.ticketId = ticketId;
        this.roomName = roomName;
        this.isNew = isNew;
        this.sold = false;
    }

    public String getTicketId() {
        return ticketId;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public boolean isNew() {
        return isNew;
    }

    public String getRoomName() {
        return roomName;
    }
}