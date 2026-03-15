package Gioi.Gioi1;


public class Main {
    public static void main(String[] args) {
        TicketPool roomA = new TicketPool("A", 2);
        TicketPool roomB = new TicketPool("B", 2);

        BookingCounter counter1 = new BookingCounter("Quầy 1", roomA, roomB);
        BookingCounter counter2 = new BookingCounter("Quầy 2", roomA, roomB);


        Thread t1 = new Thread(() -> {
            counter1.sellCombo(true);
        });

        Thread t2 = new Thread(() -> {
            counter2.sellCombo(false);
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // bản không deadlock
        TicketPool roomA2 = new TicketPool("A", 2);
        TicketPool roomB2 = new TicketPool("B", 2);

        BookingCounter safeCounter1 = new BookingCounter("Quầy 1", roomA2, roomB2);
        BookingCounter safeCounter2 = new BookingCounter("Quầy 2", roomA2, roomB2);

        Thread t3 = new Thread(() -> {
            safeCounter1.sellComboSafe();
            safeCounter1.sellComboSafe();
        });

        Thread t4 = new Thread(() -> {
            safeCounter2.sellComboSafe();
        });

        t3.start();
        t4.start();

        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}