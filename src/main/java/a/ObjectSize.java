package a;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

public class ObjectSize {
    public static void main(String[] args) {
        long tid = Thread.currentThread().getId();
        MemoryMXBean bean = ManagementFactory.getMemoryMXBean();
        long before = bean.getHeapMemoryUsage().getCommitted();
        Object obj = new Object();
        long after = bean.getHeapMemoryUsage().getCommitted();
        System.out.println(before + " -- " + (after - before));
    }
}
