package LeetCode1.每日一题;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: anzhi
 * @Date: 2021/3/23 17:45
 */
public class 扁平化嵌套列表迭代器 {

    /**
     * 嵌套的整型列表是一个树形结构，树上的叶子节点对应一个整数，非叶节点对应一个列表
     *
     */

    class NestedIterator implements Iterator<Integer> {

        private List<Integer> vals;
        private Iterator<Integer> cur;

        private NestedIterator(List<NestedInteger> nestedList) {
            vals = new ArrayList<>();
            dfs(nestedList);
            cur = vals.iterator();
        }

        @Override
        public Integer next() {
            return cur.next();
        }

        @Override
        public boolean hasNext() {
            return cur.hasNext();
        }

        private void dfs(List<NestedInteger> nestedList) {
            for (NestedInteger nest: nestedList) {
                if (nest.isInteger()) {
                    vals.add(nest.getInteger());
                } else {
                    dfs(nest.getList());
                }
            }
        }

    }











}

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
 }