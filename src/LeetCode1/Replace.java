package LeetCode1;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: anzhi
 * @Date: 2020/11/4 20:17
 */
public class Replace {

    public static void main(String[] args) {
//        String s = "We are happy.";
//        s.replace(" ", "%20");

        Map<Object, String> map = new HashMap<>();
        Student s1 = new Student();
        map.put(s1, "hello");
        s1.setName("Alice");
        System.out.println(map.get(s1));


    }


    public static void replaceSpace() {
        CharSequence oldChar = " ";
        CharSequence newChar = "%20";




    }



}

class Student {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}