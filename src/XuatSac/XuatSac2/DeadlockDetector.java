package XuatSac.XuatSac2;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class DeadlockDetector {

    public static void detect() {

        System.out.println("Đang quét deadlock...");

        ThreadMXBean bean = ManagementFactory.getThreadMXBean();

        long[] ids = bean.findDeadlockedThreads();

        if (ids == null) {
            System.out.println("Không phát hiện deadlock.");
        } else {
            System.out.println("Phát hiện deadlock!");
        }
    }
}