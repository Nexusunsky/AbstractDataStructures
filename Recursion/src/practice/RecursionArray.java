package practice;

/**
 * 递归数组:
 * 反向写出给定数组，先考虑 数组的最后一个元素
 *
 * @author: haoliu on 2018/9/24 11:35
 */
public class RecursionArray {
    public static void main(String[] args) {
        int[] temp = {1, 2, 3, 4, 5, 6, 7};
        backward(temp, 0, temp.length - 1);
    }

    private static void foreword(int[] arr, int first, int last) {
        if (first <= last) {
            backward(arr, first, last - 1);
            System.out.println(arr[last]);
        }
    }

    private static void backward(int[] arr, int first, int last) {
        if (first <= last) {
            System.out.println(arr[last]);
            backward(arr, first, last - 1);
        }
    }
}
