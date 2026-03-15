package Gioi.Gioi2;


import java.util.Random;

public class BookingCounter implements Runnable {
    private String counterName;
    private TicketPool roomA;
    private TicketPool roomB;
    private int soldCount = 0;

    public BookingCounter(String counterName, TicketPool roomA, TicketPool roomB) {
        this.counterName = counterName;
        this.roomA = roomA;
        this.roomB = roomB;
    }

    @Override
    public void run() {



        Random random = new Random();
        while (!(roomA.isSoldOut() && roomB.isSoldOut())) {
            TicketPool chosenRoom = random.nextBoolean() ? roomA : roomB;
            Ticket ticket = chosenRoom.sellTicket();

            if (ticket == null) {
                TicketPool otherRoom = (chosenRoom == roomA) ? roomB : roomA;
                ticket = otherRoom.sellTicket();
            }

            if (ticket != null) {
                soldCount++;
                System.out.println(counterName + " bán được vé " + ticket.getTicketId() +
                        (ticket.isNew() ? " (vé mới)" : " (vé cũ)"));
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(counterName + " đã bán tổng cộng " + soldCount + " vé.");
    }
}
