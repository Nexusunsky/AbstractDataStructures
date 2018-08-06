package practice;

/**
 * 2，假定桌上有一堆书，每本书太重太大，你只能拿走这堆书中最上面的一本。不能从其他书下拿走一本。
 * 类似地，可以在这堆书的最上面放另一本从而在这堆书中增加一本。不能在其他书下面增加一本。
 * 如果仅用书名表示书，设计一个可以用来纪录桌上书堆中的书的类。规范说明每个方法：
 * 说明方法的目的；描述它的参数，写方法头的伪代码。然后写一个用于书堆方法的Java接口。在代码中包括Javadoc风格的注释。
 *
 * @author: haoliu on 06/08/2018 21:42
 */
public class ProjectTwo {
    interface BookPile {
        /**
         * Get current number of entries in this bag
         *
         * @return The integer number of entries currently in the pile.
         */
        int getCurrentSize();

        /**
         * Sees whether this book pile is empty.
         *
         * @return True if the book pile is empty or false if not.
         */
        boolean isEmpty();

        /**
         * Put a book into the top of the Book pile.
         *
         * @param book The book put on.
         */
        boolean put(String book);


        /**
         * Take a book from the top of the book pile
         *
         * @return String The book taken from the book pile.
         */
        String take();
    }
}
