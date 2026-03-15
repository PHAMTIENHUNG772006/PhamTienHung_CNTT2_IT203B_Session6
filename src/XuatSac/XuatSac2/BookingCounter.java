package XuatSac.XuatSac2;

import java.util.List;
import java.util.Random;

public class BookingCounter implements Runnable {

    private String name;
    private List<Room> rooms;
    private Random random = new Random();
    private volatile boolean running = true;

    public BookingCounter(String name, List<Room> rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {

        System.out.println(name + " bắt đầu bán vé...");

        while (running) {

            Room room = rooms.get(random.nextInt(rooms.size()));

            Ticket t = room.sellTicket();

            if (t != null) {
                System.out.println(name + " bán " + t.getId());
            }

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}
