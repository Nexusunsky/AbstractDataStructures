package practice;

import main.ISet;

/**
 * 项目1，给定空集合，其对象是 Set<String>，
 * 且给定含有多个字符串的类Bag<String>的一个对象，写客户语句。
 * 从给定的包创建一个集合。
 *
 * @author: haoliu on 06/08/2018 21:26
 */
class ProjectOne {
    public static void main(String[] args) {
        IBagExtension<String> bag = new Bag<String>();
        ISet<String> set = new Set<>();
        int size = bag.getCurrentSize();

        for (int i = 0; i < size; i++) {
            final String str = bag.remove();
            set.add(str);
            while (bag.getFrequencyOf(str) > 0) {
                bag.remove(str);
            }
        }
    }
}
