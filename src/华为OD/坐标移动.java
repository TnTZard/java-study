package 华为OD;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: anzhi
 * @Date: 2020/11/23 14:41
 */
public class 坐标移动 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character, Integer> map = new HashMap<>();
        while (sc.hasNext()) {
            String str = sc.nextLine();
            int x = 0, y = 0;
            String[] array = str.split(";");
            String res = "[AWDS]\\d{1}\\d?";
            for (int i = 0; i < array.length; i++) {
                if (array[i].matches(res)) {
                    char direction = array[i].charAt(0);
                    int num = map.getOrDefault(array[i].charAt(0), 0) + Integer.parseInt(array[i].substring(1, 2));
                    map.put(direction, num);
                }
            }
            x = x - map.get('A') + map.get('D');
            y = y - map.get('S') + map.get('W');
            System.out.println(x + "," + y);
            map.clear();
        }
        sc.close();
    }
}

//import java.util.*;
//
//public class Main{
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//
//        }
//    }
//}
