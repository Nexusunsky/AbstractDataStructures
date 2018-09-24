package practice;

/**
 * 练习：写两个不同的递归算法 均返回n的阶乘
 *
 * @author: haoliu on 2018/9/24 11:01
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(3));
        System.out.println(factorial1(3));
    }

    private static int factorial(int a) {
        if (a == 0) {
            return 1;
        }
        return a * factorial(a - 1);
    }

    private static int factorial1(int a) {
        if (a >= 1)
            return a * factorial(a - 1);
        return 1;
    }
}
