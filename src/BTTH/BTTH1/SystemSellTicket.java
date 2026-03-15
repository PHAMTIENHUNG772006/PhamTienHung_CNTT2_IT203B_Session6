package BTTH.BTTH1;

public class SystemSellTicket {
    public static int totalTicket = 10;

    public static synchronized void sellTicket(){
        if (totalTicket > 0){
            totalTicket--;
        }
    }

}


