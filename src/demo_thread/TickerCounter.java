package demo_thread;

public class TickerCounter {
    public static int totalTicket = 10;

    public static synchronized void sellTicket(){
        if (totalTicket > 0){
            System.out.printf("Còn %d vé \n", totalTicket);
            totalTicket--;
            System.out.println("Person buy , totalTicket - 1");
        }
    }
}
