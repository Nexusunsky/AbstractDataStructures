## 练习

1，比较使用 数组 和 使用 链式实现的ADT栈 的优缺点；
    答：
        1，内存占用方面：
            使用数组需要预先 申请 一定的内存，而当内存不足时需要动态的再去 申请。
            而链式实现的ADT 则不需要考虑内存的申请

3，现在为栈 新增 void display();

4，定义方法toArray()取代方法display()重做前一个练习。

5，假定ADT包含了remove(n)，它从栈中删除最上面的n个元素，返回值为void。
通过注释和方法头来详述该方法，考虑对包含的元素个数不足 n个的栈的 可能处理结果。

6，实现remove(n)接口。

7，在ADT的链式实现中，若将栈顶元素放在链中的结尾处。
详述如何定义栈的操作push，pop和peek，以避免遍历链。
    当栈顶元素，放在了链的结尾处。需要额外维护一个 尾结点 来纪录尾结点的引用;
        a，对于push操作：已知尾结点的引用，
            tailNode = new Node();
            tailNode.data = entry;
            Node temp = topNode;
            while(temp.next != null) {
                temp = topNode.next;
            }
            temp.next = tailNode;
        b，对于pop操作：
            Node temp = topNode;
            while(temp.next != tailNode) {
                temp = topNode.next;
            }
            T entry = tailNode.data
            temp.next = null;
            tailNode = temp;
            return entry;
        c，对于peek操作：
            return tailNode.data;

8，基于数组栈的push方法 通常是O(1)的，但当栈需要倍增其大小时，push是O(n)的。
    不过，这个结论并不像表面上那么差。假定将 栈的大小 从 n个 元素倍增到 2n个 元素。
        a，在栈 再次倍增前需要调用多少次push?
        b，这些push调用每次都是O(1)的，所有 push 操作的平均花费是多少？
        （平均花费是指所有push调用的总花费除以push调用的次数）
    答：
        a，在调用 n 次push操作时，栈中将增加n个元素，此时当在进行一次push时，栈将倍增。因此是需要调用 n+1 次。
        b，计算倍增的平均花费即可：
            (n * O(1) + 1 * O(n)) / (n + 1) = O(1)












