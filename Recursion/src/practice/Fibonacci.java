package practice;

/**
 * 替代递归的两个迭代方法，每个都是斐波那契的第n项
 * 一个方法使用数组，
 * 另一个方法使用三个变量，保存数组的当前项与它之前的两个项 ？？？
 *
 * @author: haoliu on 2018/9/24 12:22
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(10));
    }

    private static int fib(int n) {
        int[] fibArray = new int[n + 1];
        fibArray[0] = 1;
        fibArray[1] = 1;
        for (int i = 0; i < n - 1; i++) {
            fibArray[i + 2] = fibArray[i] + fibArray[i + 1];
        }
        return fibArray[n];
    }
}
