package practice;

/**
 * 理解的不够
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
        String in = "abb";
        fullyArranged(in.toCharArray(), 0, in.length());
        fullyArrangedNoneRepeat(in.toCharArray(), 0, in.length());
    }

    /**
     * 全排列 就是 从第一个数字起 每个数 分别与它后面的数字交换
     */
    private static void fullyArranged(char[] in, int start, int length) {
        if (start == length - 1) {
            for (int i = 0; i < length; i++) {
                System.out.print(in[i]);
            }
            System.out.println();
        } else {
            //实现 嵌套迭代 length 的阶乘
            for (int i = start; i < length; i++) {
                swap(in, start, i);
                fullyArranged(in, start + 1, length);
                swap(in, start, i);
            }
        }
    }

    /**
     * 去重的全排列 就是从 第一个数字起 每个数分别与它后面 非重复 出现的数字交换。
     */
    private static void fullyArrangedNoneRepeat(char[] in, int start, int length) {
        if (start == length - 1) {
            for (int i = 0; i < length; i++) {
                System.out.print(in[i]);
            }
            System.out.println();
        } else {
            for (int i = start; i < length; i++) {
                if (isSwapped(in, start, i)) {
                    swap(in, start, i);
                    fullyArrangedNoneRepeat(in, start + 1, length);
                    swap(in, start, i);
                }
            }
        }
    }

    private static boolean isSwapped(final char[] in, final int start, final int end) {
        for (int i = start; i < end; i++) {
            if (in[i] == in[end]) {
                return false;
            }
        }
        return true;
    }

    private static void swap(char[] arr, int a, int b) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
