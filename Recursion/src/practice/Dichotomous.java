package practice;

/**
 * 16，使用递归实现 二分查找
 * 参考 数组递归的方式来进行 二分查找 区域最小值。
 *
 * @author: haoliu on 2018/9/24 17:45
 */
public class Dichotomous {
    public static void main(String[] args) {
        int[] temp = {3, 4, 2, 0, 5, 99, 7, 23, 24, 9};
        System.out.println(dichotomies(temp, 0, temp.length - 1));
    }

    private static int dichotomies(int arr[], int start, int end) {
        if (start == end)
            return min(arr[start], arr[end]);
        int mid = (start + end) / 2;
        return min(dichotomies(arr, start, mid), dichotomies(arr, mid + 1, end));
    }

    private static int min(int a, int b) {
        return a > b ? b : a;
    }
}
