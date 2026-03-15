package kha.Kha1;

import demo_thread.TickerCounter;

import java.util.Random;

public class BookingCounter implements Runnable{
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

       while (!(roomA.isSoldOut() && roomB.isSoldOut())){
           Random random = new Random();

           TicketPool chooseRom = random.nextBoolean() ? roomA : roomB;

           Ticket ticket = chooseRom.sellTicket();

           if (ticket != null){
               soldCount++;
               System.out.println(counterName + " bán được vé " + ticket.getTicketId() );
           }else {
               TicketPool ortherRom = random.nextBoolean() ? roomA : roomB;

               Ticket ortherticket = chooseRom.sellTicket();

               if (ticket != null) {
                   soldCount++;
                   System.out.println(counterName + " bán được vé " + ticket.getTicketId());
               }
           }
           try {
               Thread.sleep(100);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

       }
        System.out.println(counterName + " đã bán tổng cộng " + soldCount + " vé.");
    }

    public int getSoldCount() {
        return soldCount;
    }

    public void setSoldCount(int soldCount) {
        this.soldCount = soldCount;
    }
}
