package demo_thread;

public class Person extends Thread{
    public Person(String name) {
        super(name);
    }

    @Override
    public synchronized void run(){
        while (TickerCounter.totalTicket > 0){
            if (TickerCounter.totalTicket > 0){
                try {
                    TickerCounter.sellTicket();
                    Thread.sleep(1000);
                    System.out.println("Person đã mua vé \n");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("Vé đã bán hết");

    }
}
