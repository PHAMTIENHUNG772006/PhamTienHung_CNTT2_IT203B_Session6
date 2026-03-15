package XuatSac.XuatSac2;

import java.util.List;

public class Statistics {

    public static void show(List<Room> rooms) {

        System.out.println("=== THỐNG KÊ HIỆN TẠI ===");

        int totalSold = 0;

        for (Room r : rooms) {

            int sold = r.soldCount();
            totalSold += sold;

            System.out.println("Phòng " + r.getName() +
                    ": Đã bán " + sold + "/" + r.total() + " vé");
        }

        System.out.println("Tổng doanh thu: " + (totalSold * 150000) + " VNĐ");
    }
}