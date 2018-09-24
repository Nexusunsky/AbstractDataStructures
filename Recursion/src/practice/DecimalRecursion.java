package practice;

/**
 * 进制计算 的递归调用。
 *
 * @author: haoliu on 2018/9/24 16:47
 */
public class DecimalRecursion {
    public static void main(String[] args) {
        System.out.println(decimal(101111111));
        System.out.println(convertDecimal(101111111, 3));
    }

    private static String decimal(int n) {
        if (n == 0)
            return "";
        return decimal(n / 10) + String.valueOf(n % 10);
    }

    private static String convertDecimal(int n, int base) {
        if (n == 0)
            return "";
        return decimal(n / base) + String.valueOf(n % base);
    }
}
