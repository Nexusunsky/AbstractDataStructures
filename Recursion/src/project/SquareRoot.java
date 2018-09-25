package project;

/**
 * 求解整数的平方根 递归方法
 *
 * @author: haoliu on 2018/9/25 21:23
 */
public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(squareRoot(100, 0, 100, 0.00005));
    }

    private static float squareRoot(float number, float lowGuess, float highGuess, double tolerance) {
        float newGuess = (lowGuess + highGuess) / 2;
        if ((highGuess - newGuess) / newGuess < tolerance)
            return newGuess;
        else if (newGuess * newGuess > number)
            return squareRoot(number, lowGuess, newGuess, tolerance);
        else if (newGuess * newGuess < number)
            return squareRoot(number, newGuess, highGuess, tolerance);
        else
            return newGuess;
    }
}
