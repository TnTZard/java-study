package 基础语法;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: anzhi
 * @Date: 2021/1/11 17:24
 */
public class ThreadLocalTest {

    //private static SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static ThreadLocal<SimpleDateFormat> threadlLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    public static void main(String[] args) {
//        while (true) {
//            new Thread(() -> {
//                String dateStr = threadlLocal.get().format(new Date());
//                try {
//                    Date parseDate = threadlLocal.get().parse(dateStr);
//                    String dateStrCheck = threadlLocal.get().format(parseDate);
//                    boolean equals = dateStr.equals(dateStrCheck);
//                    if (!equals) {
//                        System.out.println(equals + " " + dateStr + " " + dateStrCheck);
//                    } else {
//                        System.out.println(equals);
//                    }
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//            }).start();
//        }
        try {
            test_threadLocalHashCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void test_threadLocalHashCode() throws Exception {
        for (int i=0; i < 5; i++) {
            ThreadLocal<Object> objectThreadLocal = new ThreadLocal<>();
            Field threadLocalHashCode = objectThreadLocal.getClass().getDeclaredField("threadLocalHashCode");
            threadLocalHashCode.setAccessible(true);
            System.out.println("objectThreadLocal: " + threadLocalHashCode.get(objectThreadLocal));
        }
    }

}
