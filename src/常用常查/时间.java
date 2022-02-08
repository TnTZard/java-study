package 常用常查;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @Author: anzhi
 * @Date: 2021/4/19 9:29
 */
public class 时间 {
    static DateTimeFormatter DTF_FULL = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
//        String s = "20210414135500";
//        int year    = Integer.parseInt(s.substring(0, 4));
//        int month   = Integer.parseInt(s.substring(4, 6));
//        int day     = Integer.parseInt(s.substring(6, 8));
//        int hour    = Integer.parseInt(s.substring(8, 10));
//        int minutes = Integer.parseInt(s.substring(10, 12));
//        int seconds = Integer.parseInt(s.substring(12, 14));
//        LocalDateTime localDateTime = LocalDateTime.of(year, month, day, hour, minutes, 0);
//        System.out.println(DTF_FULL.format(localDateTime));
       // System.out.println(createEventId());
        Set<String> set = new HashSet<>();
        set.toArray()[0].toString();
        Double a = Double.parseDouble("106.0");

        System.out.println(a.intValue());
    }

    public static String createEventId(){
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        StringBuffer str = new StringBuffer(df.format(new Date()));
        for(int i=0;i<4;i++){
            char ch=str.charAt(new Random().nextInt(str.length()));
            str.append(ch);
        }
        return str.toString();
    }




}
