package XuatSac.XuatSac1;

import java.util.List;
import java.util.Random;

public class BookingCounter extends Thread {

    private String name;
    private List<TicketPool> pools;
    private Random random = new Random();

    public BookingCounter(String name, List<TicketPool> pools) {
        this.name = name;
        this.pools = pools;
    }

    @Override
    public void run() {

        while (true) {

            try {

                TicketPool pool = pools.get(random.nextInt(pools.size()));

                Ticket ticket = pool.holdTicket(name);

                if (ticket != null) {

                    int thinkingTime = random.nextInt(7000);

                    System.out.println(name +
                            " đang suy nghĩ " +
                            thinkingTime/1000.0 + "s");

                    Thread.sleep(thinkingTime);

                    pool.sellHeldTicket(ticket);
                }

                Thread.sleep(2000);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}