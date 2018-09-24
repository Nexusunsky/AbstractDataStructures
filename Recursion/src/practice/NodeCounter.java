package practice;

/**
 * 11，写一个递归方法 统计链式结点链中 结点的个数
 *
 * @author: haoliu on 2018/9/24 16:36
 */
public class NodeCounter {
    public static void main(String[] args) {
        Node current = new Node();
        Node head = current;
        for (int i = 0; i < 20; i++) {
            Node next = new Node();
            current.next = next;
            current = next;
        }
        System.out.println(count(head, 0));
    }

    private static int count(Node current, int count) {
        if (null != current.next) {
            return count(current.next, count + 1);
        }
        return count;
    }

    private static class Node {
        private Node next;
    }
}
