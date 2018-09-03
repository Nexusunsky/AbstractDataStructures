package main;

/**
 * 中缀 转后缀 算法
 *
 * @author: haoliu on 2018/9/3 20:31
 */
public class ConvertToPostfix {

    public static void main(String[] args) {
        /*     ab/cde- + *   */
        String postfix = convertToPostfix("a/b*(c+(d-e))");
        System.out.println(postfix);
        System.out.println("Result :" + evaluatePostfix(postfix));
    }

    public static int evaluatePostfix(String postfix) {
        final int postfixLength = postfix.length();
        int index = 0;
        IStack<Integer> valueStack = new OurStack<>();

        while (index < postfixLength) {
            char nextChar = postfix.charAt(index);
            index++;
            switch (nextChar) {
                case 'a':
                    valueStack.push(2);
                    break;
                case 'b':
                    valueStack.push(3);
                    break;
                case 'c':
                    valueStack.push(4);
                    break;
                case 'd':
                    valueStack.push(5);
                    break;
                case 'e':
                    valueStack.push(6);
                    break;

                case '+': {
                    Integer param1 = valueStack.pop();
                    Integer param2 = valueStack.pop();
                    int result = param2 + param1;
                    valueStack.push(result);
                    break;
                }
                case '-': {
                    Integer param1 = valueStack.pop();
                    Integer param2 = valueStack.pop();
                    int result = param2 - param1;
                    valueStack.push(result);
                    break;
                }
                case '*': {
                    Integer param1 = valueStack.pop();
                    Integer param2 = valueStack.pop();
                    int result = param2 * param1;
                    valueStack.push(result);
                    break;
                }
                case '/': {
                    Integer param1 = valueStack.pop();
                    Integer param2 = valueStack.pop();
                    int result = param2 / param1;
                    valueStack.push(result);
                    break;
                }
                case '^': {
                    Integer param1 = valueStack.pop();
                    Integer param2 = valueStack.pop();
                    int result = param2;
                    for (int i = 0; i < param1; i++) {
                        result = result * param2;
                    }
                    valueStack.push(param1);
                    break;
                }

                default:
                    break;
            }
        }
        return valueStack.pop();
    }

    public static String convertToPostfix(String infix) {
        int infixLength = infix.length();
        int index = 0;
        Character topOperator;
        IStack<Character> operatorStack = new OurStack<>();
        IStack<Character> postfixStack = new OurStack<>();

        while (index < infixLength) {
            char nextCharacter = infix.charAt(index);
            index++;
            switch (nextCharacter) {
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                    postfixStack.push(nextCharacter);
                    break;
                case '^':
                    operatorStack.push(nextCharacter);
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!operatorStack.isEmpty()
                            && !isBasket(operatorStack.peek())
                            && isPriority(nextCharacter, operatorStack.peek())) {
                        postfixStack.push(operatorStack.pop());
                    }
                    operatorStack.push(nextCharacter);
                    break;
                case '(':
                    operatorStack.push(nextCharacter);
                    break;
                case ')':
                    topOperator = operatorStack.pop();
                    while (topOperator != '(') {
                        postfixStack.push(topOperator);
                        topOperator = operatorStack.pop();
                    }
                    break;
                default:
                    break;
            }
        }

        while (!operatorStack.isEmpty()) {
            postfixStack.push(operatorStack.pop());
        }

        StringBuilder postfix = new StringBuilder();
        while (!postfixStack.isEmpty()) {
            postfix.append(postfixStack.pop());
        }

        return postfix.reverse().toString();
    }

    private static boolean isBasket(final Character peek) {
        return peek == '(';
    }

    private static boolean isPriority(final char nextCharacter, final Character inStack) {
        return (nextCharacter == '-' || nextCharacter == '+') || (inStack != '+' && inStack != '-');
    }
}
