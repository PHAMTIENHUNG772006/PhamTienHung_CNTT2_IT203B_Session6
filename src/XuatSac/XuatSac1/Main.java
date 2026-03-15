package XuatSac.XuatSac1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        TicketPool roomA = new TicketPool("A", 5);
        TicketPool roomB = new TicketPool("B", 5);
        TicketPool roomC = new TicketPool("C", 5);

        List<TicketPool> pools = new ArrayList<>();

        pools.add(roomA);
        pools.add(roomB);
        pools.add(roomC);

        TimeoutManager manager = new TimeoutManager(pools);
        manager.start();

        for (int i = 1; i <= 5; i++) {

            BookingCounter counter =
                    new BookingCounter("Quầy " + i, pools);

            counter.start();
        }
    }
}