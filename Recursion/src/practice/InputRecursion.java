package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 练习 3：
 *
 * @author: haoliu on 2018/9/24 10:44
 */
public class InputRecursion {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        try {
            System.out.println("Please enter a num between 1 ~ 10.");
            inputRecursion();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void inputRecursion() throws IOException {
        int num = Integer.valueOf(READER.readLine());
        if (num < 1 || num > 10) {
            System.out.println("Try again.");
            inputRecursion();
        }
    }
}
