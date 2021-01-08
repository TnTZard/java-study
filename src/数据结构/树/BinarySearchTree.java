package 数据结构.树;

import java.util.Arrays;

/**
 * 二叉树
 * @Author: anzhi
 * @Date: 2021/1/8 18:00
 */
public class BinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Arrays.asList(72, 57, 82, 30, 63, 79, 90, 27, 40, 62, 67, 80, 87, 48).forEach(key -> {
            String value = "我是key为" + key + "的value";
            bst.insert(key, value);
        });
        System.out.println(bst.find(87).value);
        bst.insert(87, "hello world");
        System.out.println(bst.find(87).value);
        System.out.println("最大值" + bst.max().key);
        System.out.println("最小值" + bst.min().key);
    }

    private Node root;

    static class Node {
        int key;

        String value;

        Node leftChild;

        Node rightChild;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }


    /**
     * 插入新节点
     * @param key
     * @param value
     */
    public void insert(int key, String value) {
        // 创建一个新节点
        Node newNode = new Node(key, value);
        if (this.root == null) {
            // 如果根为null，则这个新节点就是根
            root = newNode;
        } else {
            // 如果根不为null，则从根开始搜索插入位置
            Node currentNode = root;
            // 用于暂存父节点
            Node parentNode;
            while (true) {
                parentNode = currentNode;
                if (key < currentNode.key) {
                    currentNode = currentNode.leftChild;
                    if (currentNode == null) {
                        parentNode.leftChild = newNode;
                        return;
                    }
                } else if (key > currentNode.key) {
                    currentNode = currentNode.rightChild;
                    if (currentNode == null) {
                        parentNode.rightChild = newNode;
                        return;
                    }
                } else {
                    currentNode.value = newNode.value;
                    return;
                }
            }
        }
    }

    /**
     * 查找
     * @param key
     * @return
     */
    public Node find(int key) {
        Node currentNode = root;
        while (currentNode.key != key) {
            if (key < currentNode.key) {
                currentNode = currentNode.leftChild;
            } else {
                currentNode = currentNode.rightChild;
            }
            // 如果当前节点为null，说明查到叶子节点了，仍然没查到目标key，则直接返回null
            if (currentNode == null) {
                return null;
            }
        }
        return currentNode;
    }


    public boolean delete(int key) {
        // 从根节点开始查找
        Node deleteNode = root;
        // 暂存需要被删除节点的父节点
        Node parentNode = root;

        boolean isLeftChild = false;

        while (deleteNode.key != key) {

        }
    }



    public Node min() {
        Node currentNode = root;
        while (currentNode.leftChild != null) {
            currentNode = currentNode.leftChild;
        }
        return currentNode;
    }


    public Node max() {
        Node currentNode = root;
        while (currentNode.rightChild != null) {
            currentNode = currentNode.rightChild;
        }
        return currentNode;
    }

}
