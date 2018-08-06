package practice;

/**
 * 3，ring 环是项的集合，它有一个指向当前项的引用。
 * 操作(advance)将引用指向集合(collection)中的下一项。
 * 当引用到达最后一项时，下一次advance操作将引用指向第一项。
 * 环还有得到当前项，添加一项及删除一项的操作。项添加的位置和删除的位置由你来定。
 * 设计一个 ADT 来表示对象的环。说明每个方法：说明方法的目的；描述参数；写方法头的伪代码。
 * 然后写一个用于环方法的Java接口，在代码中包括javadoc风格的注释。
 *
 * @author: haoliu on 06/08/2018 21:59
 */
public class ProjectThree {
    interface Ring<T> {
        /**
         * Get current number of entries in this Ring
         *
         * @return The integer number of entries currently in the Ring.
         */
        int getCurrentSize();

        /**
         * Sees whether this Ring is empty.
         *
         * @return True if the Ring is empty or false if not.
         */
        boolean isEmpty();

        /**
         * 删除 指针目前所指向的项。如果当前Ring的size 不为 0
         *
         * @return T Either the removed entry, if the removal was successful, or null.
         */
        T remove();

        /**
         * Removes one occurrence of a given index from this ring, if possible.
         *
         * @param index the index which are targeted to be removed.
         * @return Either the removed entry, if the removal was successful, or null.
         */
        T remove(int index);

        /**
         * 移动 ring 的指针到下一项，并且返回 指针所指向的项在环中的序列号。
         *
         * @return int Index which the ring is pointed at.
         */
        int advance();
    }
}
