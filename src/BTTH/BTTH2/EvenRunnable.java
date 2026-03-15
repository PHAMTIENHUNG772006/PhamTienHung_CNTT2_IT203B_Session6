package BTTH.BTTH2;

public class EvenRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0){
                System.out.println("Số chẵn :" +  i);
            }
        }
    }
}
