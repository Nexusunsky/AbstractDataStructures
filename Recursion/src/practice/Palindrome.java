package practice;

/**
 * palindrome  使用递归实现 回文
 *
 * @author: haoliu on 2018/9/24 12:04
 */
public class Palindrome {
    public static void main(String[] args) {
        String src = "level";
        System.out.println(isPalindrome(src.toCharArray(), 0, src.length() - 1));
    }

    private static boolean isPalindrome(char[] article, int first, int last) {
        if (first >= last)
            return true;
        if (article[first] == article[last])
            return isPalindrome(article, first + 1, last - 1);
        return false;
    }
}
