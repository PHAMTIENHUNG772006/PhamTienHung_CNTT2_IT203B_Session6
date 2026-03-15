package Gioi.Gioi1;


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

    public boolean sellCombo(boolean lockAFirst) {
        if (lockAFirst) {
            synchronized (roomA) {
                Ticket ticketA = roomA.sellTicket();
                System.out.println("Quầy 1: Đã lấy " + ticketA.getTicketId());
                System.out.println("Quầy 1: Đang chờ vé B...");
                synchronized (roomB) {

                    Ticket ticketB = roomB.sellTicket();
                    if (ticketA != null && ticketB != null) {
                        System.out.println("Combo thành công: " + ticketA.getTicketId() + " & " + ticketB.getTicketId());
                        return true;
                    } else {
                        roomA.returnTicket(ticketA);
                        roomB.returnTicket(ticketB);
                        System.out.println("Combo thất bại");
                        return false;

                    }
                }
            }
        } else {
            synchronized (roomB) {
                Ticket ticketB = roomB.sellTicket();
                System.out.println("Quầy 2: Đã lấy " + ticketB.getTicketId());
                System.out.println("Quầy 2: Đang chờ vé A...");
                synchronized (roomA) {

                    Ticket ticketA = roomA.sellTicket();
                    if (ticketA != null && ticketB != null) {
                        System.out.println("Combo thành công: " + ticketA + " & " + ticketB);
                        return true;
                    } else {
                        roomA.returnTicket(ticketA);
                        roomB.returnTicket(ticketB);
                        System.out.println("Combo thất bại");
                        return false;
                    }
                }
            }
        }
    }

    public boolean sellComboSafe() {
        synchronized (roomA) {
            synchronized (roomB) {
                Ticket ticketA = roomA.sellTicket();
                Ticket ticketB = roomB.sellTicket();
                if (ticketA != null && ticketB != null) {
                    System.out.println("Combo thành công: " + ticketA.getTicketId() + " & " + ticketB.getTicketId());
                    return true;
                } else {
                    roomA.returnTicket(ticketA);
                    roomB.returnTicket(ticketB);
                    System.out.println("Combo thất bại");
                    return false;
                }
            }
        }
    }

}
