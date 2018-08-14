/**
 * ArrayBag的测试
 * A Test of the constructors and the methods add and toArray ,
 * as defined in the first draft of the class ArrayBag.
 *
 * @author: haoliu on 14/08/2018 22:36
 */
public class ArrayBagDemo1 {
    public static void main(String[] args) {
        IBag<String> aBag = new ArrayBag<>();
        String[] contentOfBag1 = {"A", "B", "A", "C", "B", "C", "D"};
        testAdd(aBag, contentOfBag1);

        aBag = new ArrayBag<>(7);
        String[] contentOfBag2 = {"A", "B", "A", "C", "B", "C", "D", "another String"};
        testAdd(aBag, contentOfBag2);
    }

    private static void testAdd(IBag<String> aBag, String[] content) {
        for (final String str : content) {
            if (aBag.add(str))
                System.out.print(str + " ");
            else
                System.out.print("\nUnable to add " + str + " to the bag.");
        }
        System.out.println();

        displayBag(aBag);
    }

    private static void displayBag(IBag<String> aBag) {
        System.out.println("The bag contains the following string(s):");
        Object[] bagArray = aBag.toArray();
        for (final Object aBagArray : bagArray) {
            System.out.print(aBagArray + " ");
        }
        System.out.println(" ");
    }
}
