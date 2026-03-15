package XuatSac.XuatSac1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TicketPool {

    private String roomName;
    private List<Ticket> tickets;
    private Random random = new Random();

    public TicketPool(String roomName, int capacity) {

        this.roomName = roomName;
        tickets = new ArrayList<>();

        for (int i = 1; i <= capacity; i++) {

            boolean isVip = random.nextBoolean();

            tickets.add(new Ticket(
                    roomName + "-" + String.format("%03d", i),
                    roomName,
                    isVip
            ));
        }
    }

    public synchronized Ticket holdTicket( String counterName) {

        for (Ticket ticket : tickets) {

            if (!ticket.isSold() && !ticket.isHeld()) {

                ticket.setHeld(true);
                ticket.setHoldExpiryTime(System.currentTimeMillis() + 5000);

                System.out.println(counterName + ": Đã giữ vé "
                        + ticket.getTicketId()
                        + (ticket.isVIP() ? " (VIP)" : "")
                        + ". Vui lòng thanh toán trong 5s");

                return ticket;
            }
        }

        return null;
    }

    public synchronized void sellHeldTicket(Ticket ticket) {

        if (ticket != null && ticket.isHeld()) {

            ticket.setSold(true);
            ticket.setHeld(false);

            System.out.println("Thanh toán thành công vé "
                    + ticket.getTicketId());
        }
    }

    public synchronized void releaseExpiredTickets() {

        long now = System.currentTimeMillis();

        for (Ticket ticket : tickets) {

            if (ticket.isHeld()
                    && !ticket.isSold()
                    && ticket.getHoldExpiryTime() <= now) {

                ticket.setHeld(false);

                System.out.println("TimeoutManager: Vé "
                        + ticket.getTicketId()
                        + " hết hạn giữ, đã trả lại kho");
            }
        }
    }

    public boolean isSoldOut() {
        return tickets.stream().allMatch(Ticket::isSold);
    }

    public int remainingTickets() {
        return (int) tickets.stream().filter(t -> !t.isSold()).count();
    }

    public String getRoomName() {
        return roomName;
    }
}