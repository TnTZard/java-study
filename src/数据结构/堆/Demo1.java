package 数据结构.堆;

import java.util.PriorityQueue;

/**
 * @Author: anzhi
 * @Date: 2021/3/22 17:52
 */
public class Demo1 {


    public static void main(String[] args) {

    }

    public int lastStoneWeight(int[] stones) {
        // 优先级的一个队列
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        for (int stone: stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a > b) {
                pq.offer(a - b);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }







}
