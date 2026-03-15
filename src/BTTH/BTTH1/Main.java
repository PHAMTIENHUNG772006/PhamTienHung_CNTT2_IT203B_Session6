package BTTH.BTTH1;

public class Main {
    public static void main(String[] args) {

        Thread shop1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int counter = 0;
                while (SystemSellTicket.totalTicket > 0){

                    System.out.println("Shop 1 mua đã mua đc 1 vé ");
                    SystemSellTicket.sellTicket();
                    counter++;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Số lượng vé shop 1 mua đc là : " + counter);
            }
        });

        Thread shop2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int counter = 0;
                while (SystemSellTicket.totalTicket > 0){

                    System.out.println("Shop 2 mua đã mua đc 1 vé ");
                    SystemSellTicket.sellTicket();
                    counter++;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Số lượng vé shop 2 mua đc là : " + counter);
            }
        });

        Thread shop3 = new Thread(new Runnable() {
            @Override
            public void run() {
                int counter = 0;
                while (SystemSellTicket.totalTicket > 0){

                    System.out.println("Shop 3 mua đã mua đc 1 vé ");
                    SystemSellTicket.sellTicket();
                    counter++;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Số lượng vé shop 3 mua đc là : " + counter);
            }
        });

        shop1.start();
        shop2.start();
        shop3.start();
    }
}
