package XuatSac.XuatSac2;


import java.util.*;
import java.util.concurrent.*;

public class Main {

    static ExecutorService executor;
    static List<Room> rooms = new ArrayList<>();
    static List<BookingCounter> counters = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n=== MENU ===");
            System.out.println("1. Bắt đầu mô phỏng");
            System.out.println("2. Tạm dừng");
            System.out.println("3. Tiếp tục");
            System.out.println("4. Thêm phòng");
            System.out.println("5. Xem thống kê");
            System.out.println("6. Phát hiện deadlock");
            System.out.println("7. Thoát");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Số phòng: ");
                    int roomCount = sc.nextInt();

                    System.out.print("Vé/phòng: ");
                    int ticketCount = sc.nextInt();

                    System.out.print("Số quầy: ");
                    int counterCount = sc.nextInt();

                    rooms.clear();

                    for (int i = 0; i < roomCount; i++) {

                        char name = (char) ('A' + i);
                        rooms.add(new Room("" + name, ticketCount));
                    }

                    executor = Executors.newFixedThreadPool(counterCount);

                    for (int i = 1; i <= counterCount; i++) {

                        BookingCounter c =
                                new BookingCounter("Quầy " + i, rooms);

                        counters.add(c);
                        executor.submit(c);
                    }

                    System.out.println("Đã khởi tạo hệ thống với "
                            + roomCount + " phòng.");

                    break;

                case 2:

                    counters.forEach(BookingCounter::stop);
                    System.out.println("Đã tạm dừng.");

                    break;

                case 3:

                    System.out.println("Tiếp tục chưa implement.");

                    break;

                case 4:

                    System.out.print("Tên phòng: ");
                    String name = sc.next();

                    System.out.print("Số vé: ");
                    int cap = sc.nextInt();

                    rooms.add(new Room(name, cap));

                    break;

                case 5:

                    Statistics.show(rooms);

                    break;

                case 6:

                    DeadlockDetector.detect();

                    break;

                case 7:

                    if (executor != null) executor.shutdownNow();

                    System.out.println("Kết thúc chương trình.");
                    return;
            }
        }
    }
}