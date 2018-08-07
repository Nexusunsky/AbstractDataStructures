package practice;

/**
 * 6，一个矩阵 是数值的一个矩形数组。可以将两个矩阵相加或相乘得到第三个矩阵。可以用一个矩阵乘上一个标量，可以转置矩阵。
 * 设计一个表示有这些操作的矩阵的ADT。
 * 说明每个ADT操作，说明方法的目的，描述它的参数，写方法头的伪代码。然后写一个用于矩阵方法的Java接口，Javadoc注释。
 *
 * @author: haoliu on 06/08/2018 23:01
 */
public class ProjectSix {
    abstract class BaseMatrix<T> {
        /**
         * 内部维护的矩形数组
         */
        protected T[][] matrix;

        /**
         * 相加两个矩阵，并得到第三个矩阵
         *
         * @param other 另一个矩阵
         * @return BaseMatrix
         */
        abstract BaseMatrix add(BaseMatrix other);

        /**
         * 相乘两个矩阵，并得到第三个矩阵
         *
         * @param other 另一个矩阵
         * @return BaseMatrix
         */
        abstract BaseMatrix multiply(BaseMatrix other);

        /**
         * 矩阵乘以一个标量得到一个新的标量
         *
         * @param scalar 标量
         */
        abstract void multiply(int scalar);

        /**
         * 矩阵装置
         */
        abstract void transposed();
    }
}
