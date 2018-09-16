package main;

/**
 * @author: haoliu on 2018/9/3 20:11
 */
public class CheckBalance {

    public static boolean checkBalance(String expression) {
        IStack<Character> openDelimiterStack = new ArrayStack<>();
        int characterCount = expression.length();
        boolean isBalanced = true;
        int index = 0;
        char nextCharacter = ' ';

        while (isBalanced && (index < characterCount)) {
            nextCharacter = expression.charAt(index);
            switch (nextCharacter) {
                case 'C':
                case '[':
                case '{':
                    openDelimiterStack.push(nextCharacter);
                    break;
                case ')':
                case ']':
                case '}':
                    if (openDelimiterStack.isEmpty())
                        isBalanced = false;
                    else {
                        char openDelimiter = openDelimiterStack.pop();
                        isBalanced = isPaired(openDelimiter, nextCharacter);
                    }
                    break;
                default:
                    break;
            }
            index++;
        }

        if (!openDelimiterStack.isEmpty())
            isBalanced = false;
        return isBalanced;
    }

    private static boolean isPaired(final char open, final char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }
}
