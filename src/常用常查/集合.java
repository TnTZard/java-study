package 常用常查;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @Author: anzhi
 * @Date: 2021/4/1 16:57
 */
public class 集合 {


    public static void main(String[] args) {

        Student student4 = new Student(4);
        Student student3 = new Student(3);
        Student student1 = new Student(1);
        Student student2 = new Student(2);
        List<Student> students = new ArrayList<>();
        students.add(student4);
        students.add(student3);
        students.add(student1);
        students.add(student2);
        List<Student> collect = students.stream().sorted(Comparator.comparing(Student::getId)).collect(Collectors.toList());
        System.out.println(collect);


        

//        Set<Integer> set = new HashSet<>();
//        Map<String, Integer> map = new HashMap<>();
//        int[] arr = new int[]{1,2,3,3};
//        int[] s = Arrays.stream(arr).distinct().toArray();
//
//        System.out.println();

//        List<Integer> arrayList = new ArrayList<>();
//        List<Integer> linkedList = new LinkedList<>();
//        String s = "ssss";
//
//        Set<Integer> set = new HashSet<>();
//        set.add(1);

//        HashMap<Integer, String> map = new HashMap<>();
//        ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
//        List<Integer> arrayList =  new ArrayList<>();
//        List<Integer> linkedList = new LinkedList<>();
//        System.out.println(map.put(1, "Alice"));
//        System.out.println(map.put(2, "Tom"));
//        System.out.println(map.put(3, "Jack"));
//        System.out.println(map.put(1, "Tony"));
//        int n = 3;
//        System.out.println(n);
//
//        int[] nums = new int[]{9, 10, 23, 34, 2, 5, 1, 9, 6};
//        Arrays.sort(nums);
//        for (int i: nums) {
//            System.out.print(i + " ");
//        }
//        double a = Math.ceil(7 / 6);
//        System.out.println((int)a);
//        System.out.println("anzhi anzhi1 key................".getBytes().length);
        xorOperation(5, 0);

    }

    static class Student {

        public Student(Integer id) {
            this.id = id;
        }

        private Integer id;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }

    public static int xorOperation(int n, int start) {
        int[] nums = new int[n ];
        Arrays.sort(nums);
        for (int i=0; i<n; i++) {
            nums[i] = start + 2*i;
            System.out.println(nums[i]);
        }
        int res = nums[0];
        for (int i=1; i<n; i++) {
            res = res ^ nums[i];
        }
        return res;
    }

//    public void getCustomerInfo() {
//        try {
//            // do something that may cause an Exception
//        } catch (java.io.FileNotFoundException ex) {
//            System.out.print("FileNotFoundException!");
//        } catch (java.io.IOException ex) {
//            System.out.print("IOException!");
//        } catch (java.lang.Exception ex) {
//            System.out.print("Exception!");
//        }
//    }




    // 并发集合
    // ConcurrentHashMap
    // CopyOnWriteArrayList
    // ConcurrentLinkedQueue
    // BlockingQueue
    // ConcurrentSkipListMap




}
