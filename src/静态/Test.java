package 静态;

/**
 * @Author: anzhi
 * @Date: 2021/3/8 13:54
 */
public class Test {
    static int x;
    class Student {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    public static void main(String[] args) {
        String str = "123";
        changeStr(str);
        System.out.println(x);
        System.out.println(str);
    }


    public static void changeStr(String str) {
        str = "welcome";
    }

    public static void changeStudent(Student student) {
        student.setName("Alice");
    }

}
