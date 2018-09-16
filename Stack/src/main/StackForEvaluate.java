package main;

/**
 * 中缀 转后缀 算法
 *
 * @author: haoliu on 2018/9/3 20:31
 */
public class StackForEvaluate {
    public static void main(String[] args) {
        evaluationTest1();
        evaluationTest2();
        convertTest1();
        convertTest2();
        expression();
    }

    private static void evaluationTest2() {
        System.out.println(evaluateInfix("a+b*c-(c+d)"));
        System.out.println(evaluateInfix("(a+e)/(b-d)"));
        System.out.println(evaluateInfix("a+(b+c*d)-e/b"));
        System.out.println(evaluateInfix("e-b*c^a+d"));
    }

    private static void evaluationTest1() {
        System.out.println(evaluatePostfix("ae+bd-/"));
        System.out.println(evaluatePostfix("abc*d*-"));
        System.out.println(evaluatePostfix("abc-/d*"));
        System.out.println(evaluatePostfix("ebca^*+d-"));
    }

    private static void convertTest2() {
        System.out.println(convertToPostfix("(a+b)/(c-d)"));
        System.out.println(convertToPostfix("a/(b-c)*d"));
        System.out.println(convertToPostfix("a-(b/(c-d)*e+f)^g"));
        System.out.println(convertToPostfix("(a-b*c)/(d*e^f*g+h)"));
    }

    private static void convertTest1() {
        System.out.println(convertToPostfix("a+b*c"));
        System.out.println(convertToPostfix("a*b/(c-d)"));
        System.out.println(convertToPostfix("a/b+(c-d)"));
        System.out.println(convertToPostfix("a/b+c-d"));
    }

    private static void expression() {
        int a = 2, b = 3, c = 4, d = 5, e = 6;
        int result = (e - b * c * c * c) + d;
        System.out.println("Result :" + result);

        String infix = "(e-b*c^a)+d";
        String postfix = convertToPostfix(infix);
        System.out.println(postfix);
        System.out.println("Result :" + evaluatePostfix(postfix));

        System.out.println("Result :" + evaluateInfix(infix));
    }

    public static int evaluateInfix(String infix) {
        int infixLength = infix.length();
        int index = 0;
        IStack<Integer> valueStack = new ArrayStack<>();
        IStack<Character> operatorStack = new ArrayStack<>();

        while (index < infixLength) {
            char nextChar = infix.charAt(index);
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

                case '^': {
                    operatorStack.push(nextChar);
                    break;
                }
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!operatorStack.isEmpty()
                            && notInBasket(operatorStack.peek())
                            && isStackPriority(nextChar, operatorStack.peek())) {
                        int result = evaluate(valueStack, operatorStack);
                        valueStack.push(result);
                    }
                    operatorStack.push(nextChar);
                    break;
                case '(':
                    operatorStack.push(nextChar);
                    break;
                case ')':
                    Character topChar = operatorStack.pop();
                    while (topChar != '(') {
                        Integer p2 = valueStack.pop();
                        Integer p1 = valueStack.pop();
                        int result = 0;
                        result = switchCase(topChar, p2, p1, result);
                        valueStack.push(result);
                        topChar = operatorStack.pop();
                    }
                    break;
                default:
                    break;
            }
        }

        while (!operatorStack.isEmpty()) {
            int result = evaluate(valueStack, operatorStack);
            valueStack.push(result);
        }
        return valueStack.peek();
    }

    private static int switchCase(final Character topChar, final Integer p2, final Integer p1, int result) {
        switch (topChar) {
            case '+':
                result = p1 + p2;
                break;
            case '-':
                result = p1 - p2;
                break;
            case '*':
                result = p1 * p2;
                break;
            case '/':
                result = p1 / p2;
                break;
            case '^':
                result = 1;
                for (int i = 0; i < p2; i++) {
                    result = result * p1;
                }
                break;
        }
        return result;
    }

    private static int evaluate(final IStack<Integer> valueStack, final IStack<Character> operatorStack) {
        Integer p2 = valueStack.pop();
        Integer p1 = valueStack.pop();
        int result = 0;
        Character topChar = operatorStack.pop();
        return switchCase(topChar, p2, p1, result);
    }

    public static int evaluatePostfix(String postfix) {
        final int postfixLength = postfix.length();
        int index = 0;
        IStack<Integer> valueStack = new ArrayStack<>();

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
                    int result = 1;
                    for (int i = 0; i < param1; i++) {
                        result = result * param2;
                    }
                    valueStack.push(result);
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
        IStack<Character> operatorStack = new ArrayStack<>();
        IStack<Character> postfixStack = new ArrayStack<>();

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
                            && notInBasket(operatorStack.peek())
                            && isStackPriority(nextCharacter, operatorStack.peek())) {
                        postfixStack.push(operatorStack.pop());
                    }
                    operatorStack.push(nextCharacter);
                    break;
                case '(':
                    operatorStack.push(nextCharacter);
                    break;
                case ')':
                    Character topOperator = operatorStack.pop();
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

    private static boolean notInBasket(final Character peek) {
        return peek != '(';
    }

    private static boolean isStackPriority(final char nextCharacter, final Character inStack) {
        return inStack == '^'
                || (nextCharacter == '-' || nextCharacter == '+')
                || (inStack != '+' && inStack != '-');
    }
}
