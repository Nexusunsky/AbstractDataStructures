package main;


/**
 * 递归处理数组
 *
 * @author: haoliu on 2018/9/19 07:14
 */
public class DisplayArray {
    public static void main(String[] args) {
        int[] temp = {1, 2, 3, 4, 5, 6, 7};
        //        displayArrayFirst(temp, 0, temp.length - 1);
        //        displayArrayLast(temp, 0, temp.length - 1);
        displayArraySplit(temp, 0, temp.length - 1);
    }

    private static void displayArrayFirst(int arr[], int first, int last) {
        System.out.println(arr[first] + " ");
        if (first < last) {
            displayArrayFirst(arr, first + 1, last);
        }
    }

    /*从 arr[last]开始 递归， 但仍从第一个元素开始显示数组中的内容 */
    private static void displayArrayLast(int arr[], int first, int last) {
        if (first <= last) {
            displayArrayLast(arr, first, last - 1);
            System.out.println(arr[last] + " ");
        }
    }

    /*拆分数组为前后两部分显示*/
    private static void displayArraySplit(int arr[], int first, int last) {
        if (first == last) {
            System.out.println(arr[first] + " ");
        } else {
            int mid = (first + last) / 2;
            displayArraySplit(arr, first, mid);//从前向后逼近
            displayArraySplit(arr, mid + 1, last);//后向前逼近
        }
    }

    private static void displayChainBackward(Node nodeOne) {
        if (nodeOne != null) {
            displayChainBackward(nodeOne.getNext());
            System.out.println(nodeOne.getData());
        }
    }

    private class Node<T> {
        Node getNext() {
            return new Node();
        }

        T getData() {
            return (T) new Object();
        }
    }
}
