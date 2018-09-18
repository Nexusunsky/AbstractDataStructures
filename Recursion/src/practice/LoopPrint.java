package practice;

/**
 * Self test 1
 *
 * @author: haoliu on 2018/9/18 22:25
 */
public class LoopPrint {
    public static void main(String[] args) {
        loopPrint(7);
        countUp(0);
    }

    private static void loopPrint(int n) {
        System.out.println("Loop in " + n);
        if (n > 0) {
            System.out.println("\n");
            loopPrint(n - 1);
        }
    }

    private static void countUp(int n) {
        if (n > 17) {
            return;
        }
        System.out.println("Count up to " + n);
        countUp(n + 1);
    }
}
