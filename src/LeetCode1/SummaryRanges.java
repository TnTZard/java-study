package LeetCode1;

import java.util.LinkedList;

/**
 * @author xiezq1
 * @version 1.0.0
 * @date 2021/10/9 10:27
 */
public class SummaryRanges {

    LinkedList<LinkedList<Integer>> list;

    public SummaryRanges() {
        list = new LinkedList<>();
    }

    public void addNum(int val) {
        LinkedList<Integer> aList = new LinkedList<>();
        aList.add(val);
    }

    public int[][] getIntervals() {
        return null;
    }

}
