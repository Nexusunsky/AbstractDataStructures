package practice;

/**
 * 5，假定 数组的两部分中 都不含有 中间元素。这样，你可以递归地 显示左半部分，
 * 显示中间元素，然后在递归地 显示右半部分。如果这样修改，则如何实现。
 *
 * @author: haoliu on 2018/9/19 07:14
 */
public class DisplayRecursion {
    public static void main(String[] args) {
        int[] temp = {1, 2, 3, 4, 5, 6, 7};
        displayArray(temp, 0, temp.length - 1);
        displayRowOfCharacters('*', 5);
    }

    private static void displayArray(int arr[], int first, int last) {
        if (first == last) {
            System.out.println(arr[first] + " ");
        } else {
            int mid = (first + last) / 2;
            displayArray(arr, first, mid - 1);//递归地显示左半部分
            System.out.println(arr[mid] + " ");//显示中间部分
            displayArray(arr, mid + 1, last);//递归地显示右半部分
        }
    }

    private static void displayRowOfCharacters(char ch, int times) {
        if (times > 0) {
            System.out.print(ch);
            displayRowOfCharacters(ch, times - 1);
        }
    }
}
