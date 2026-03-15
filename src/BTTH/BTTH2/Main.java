package BTTH.BTTH2;

public class Main {
    public static void main(String[] args) {
        EvenRunnable evenTask = new EvenRunnable();
        OddRunnable oddTask = new OddRunnable();



        Thread t1 = new Thread(evenTask);
        Thread t2 = new Thread(oddTask);

        t1.start();
        t2.start();


        System.out.println(">>> Thread chính kết thúc <<<");
    }
}
