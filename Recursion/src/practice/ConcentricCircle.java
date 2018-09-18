package practice;

/**
 * @author: haoliu on 2018/9/18 22:36
 */
class ConcentricCircle {
    public static void main(String[] args) {
        concentricCircle(100);
    }

    private static void concentricCircle(int n) {
        if (n == 0) {
            return;
        }
        concentricCircle(3 * n / 4);
        System.out.println("Concentric Circle diameter is " + n);
    }
}
