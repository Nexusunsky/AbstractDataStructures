package practice;

/**
 * 全排列
 * 写 一个静态递归方法，显示传给方法的字符串中 各字符 的全排列。
 * <p>
 * 例如：
 * 字符串序列是abc，其排列有，acb，bac，bca，cab，cba；
 *
 * @author: haoliu on 2018/9/24 20:03
 */
public class FullyArranged {
    public static void main(String[] args) {
        String in = "abc";
        fullyArranged(in.toCharArray(), 0, in.length());
    }

    private static void fullyArranged(char[] in, int start, int length) {
        if (start == length - 1) {
            for (int i = 0; i < length; i++) {
                System.out.print(in[i]);
            }
            System.out.println();
        } else {
            for (int i = start; i < length; i++) {
                swap(in, start, i);
                fullyArranged(in, start + 1, length);
                swap(in, start, i);
            }
        }
    }

    private static void swap(char[] arr, int a, int b) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
