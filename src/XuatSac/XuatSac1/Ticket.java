package XuatSac.XuatSac1;
public class Ticket {

    private String ticketId;
    private String roomName;

    private boolean sold;
    private boolean isHeld;
    private boolean isVIP;

    private long holdExpiryTime;

    public Ticket(String ticketId, String roomName, boolean isVIP) {
        this.ticketId = ticketId;
        this.roomName = roomName;
        this.sold = false;
        this.isHeld = false;
        this.isVIP = isVIP;
        this.holdExpiryTime = 0;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getRoomName() {
        return roomName;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public boolean isHeld() {
        return isHeld;
    }

    public void setHeld(boolean held) {
        isHeld = held;
    }

    public boolean isVIP() {
        return isVIP;
    }

    public void setVIP(boolean VIP) {
        isVIP = VIP;
    }

    public long getHoldExpiryTime() {
        return holdExpiryTime;
    }

    public void setHoldExpiryTime(long holdExpiryTime) {
        this.holdExpiryTime = holdExpiryTime;
    }
}