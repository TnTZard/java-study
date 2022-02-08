package 排序;

/**
 * @Author: anzhi
 * @Date: 2021/3/24 11:15
 */
public class 选择排序 {


    public void selectSort(int[] a) {
        int length = a.length;
        for (int i=0; i<length; i++) {
            int key = a[i];
            int position = i;
            for (int j=i+1; j<length; j++) {
                if (a[j] < key) {
                    key = a[j];
                    position = j;
                }
            }
            a[position] = a[i];
            a[i] = key;
        }
    }


    public void heapSort(int[] a) {
        int arrayLength = a.length;
        // 循环建堆
        for (int i=0; i<arrayLength-1; i++) {
            // 建堆
            buildMaxHeap(a, arrayLength-1-i);
        }
    }

    // 对data数组从0到lastIndex建大顶堆
    private void buildMaxHeap(int[] data, int n) {
        // 从lastIndex（最后一个节点）节点的父节点开始
    }




}
