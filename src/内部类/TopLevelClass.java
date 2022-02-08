package 内部类;

/**
 * @author xiezq1
 * @version 1.0.0
 * @date 2021/12/21 16:41
 */
public class TopLevelClass {

    void accessMembers(OuterClass outer) {
        //System.out.println(OuterClass.outerField);
        System.out.println(outer.outerField);
        System.out.println(OuterClass.staticOuterField);
    }



}
