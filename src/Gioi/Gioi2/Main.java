package Gioi.Gioi2;


public class Main {
    public static void main(String[] args) {
        TicketPool roomA = new TicketPool("A", 2);
        TicketPool roomB = new TicketPool("B", 10);

        BookingCounter counter1 = new BookingCounter("Quầy 1", roomA, roomB);
        BookingCounter counter2 = new BookingCounter("Quầy 2", roomA, roomB);
        TicketSupplier supplier = new TicketSupplier(roomA, roomB, 3, 3000, 1);

        Thread t1 = new Thread(counter1);
        Thread t2 = new Thread(counter2);
        Thread tSupplier = new Thread(supplier);



        t1.start();
        t2.start();
        tSupplier.start();


        try {
            t1.join();
            t2.join();
            tSupplier.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
