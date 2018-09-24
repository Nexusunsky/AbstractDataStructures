package practice;

/**
 * 写四个不同的递归方法，每一个都计算数组中各个整数的和，模仿7.4节和自测题5的描述。
 *
 * @author: haoliu on 2018/9/24 17:11
 */
public class ComputeArray {

    public static void main(String[] args) {
        int[] temp = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(computeArray(temp, 0, temp.length - 1));
        System.out.println(computeArray1(temp, 0, temp.length - 1));
        System.out.println(computeArray2(temp, 0, temp.length - 1));
        System.out.println(computeArray3(temp, 0, temp.length - 1));
    }

    private static int computeArray(int arr[], int start, int end) {
        if (start < end) {
            return arr[start] + computeArray(arr, start + 1, end);
        }
        return arr[start];
    }

    private static int computeArray1(int arr[], int start, int end) {
        if (start < end) {
            return arr[end] + computeArray1(arr, start, end - 1);
        }
        return arr[end];
    }

    /*将问题 拆分成了 start mid end 三个部分，然后从三个方向进行趋紧 */
    private static int computeArray2(int arr[], int start, int end) {
        if (start == end) {
            return arr[start];
        } else {
            int mid = (start + end) / 2;
            return computeArray2(arr, start, mid) + computeArray2(arr, mid + 1, end);
        }
    }

    private static int computeArray3(int arr[], int start, int end) {
        if (start == end) {
            return arr[start];
        } else {
            int mid = (start + end) / 2;
            //递归地 显示 左半部分 start ~ mid-1，中间元素arr[mid]，右半部分 mid+1 ~ end
            return computeArray3(arr, start, mid - 1) + arr[mid] + computeArray3(arr, mid + 1, end);
        }
    }
}
