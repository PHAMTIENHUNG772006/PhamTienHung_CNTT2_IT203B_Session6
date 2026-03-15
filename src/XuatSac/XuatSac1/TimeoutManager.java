package XuatSac.XuatSac1;

import java.util.List;

public class TimeoutManager extends Thread {

    private List<TicketPool> pools;

    public TimeoutManager(List<TicketPool> pools) {
        this.pools = pools;
    }

    @Override
    public void run() {

        while (true) {

            try {

                for (TicketPool pool : pools) {
                    pool.releaseExpiredTickets();
                }

                Thread.sleep(500);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}