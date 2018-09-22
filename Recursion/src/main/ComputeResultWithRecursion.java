package main;

/**
 * @author: haoliu on 2018/9/22 17:19
 */
public class ComputeResultWithRecursion {
    public static void main(String[] args) {
        System.out.println(multiOf(10));
    }

    private static int sumOf(int n) {
        int sum;
        if (n == 1)
            sum = 1;
        else
            sum = sumOf(n - 1) + n;
        return sum;
    }

    private static int multiOf(int n) {
        int multi, a = 2;
        if (n == 0)
            multi = 1;
        else
            multi = multiOf(n - 1) * a;
        return multi;
    }

    private static int multiOf2(int n) {
        int multi, a = 2;
        if (n == 0)
            multi = 1;
        else
            multi = a * multiOf2(n / 2) * multiOf2(n / 2);
        return multi;
    }
}
