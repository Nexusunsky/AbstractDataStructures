自测题：

    1，老师仅知道一把椅子的地址。
    a，这把椅子在链的什么位置：第一个，最后一个，或者其他某个位置？
        答：第一个位置。

    b，谁坐在那把椅子上，最先到达的学生，最后到达的学生或者其他人？
        答：最后到达的学生。

    2，在椅子链中，新的椅子添加在什么位置：开头，结尾或者其他的位置。
        答：新的椅子添加在结尾。 ==> 开头

    3，在前面方法add：初建 结点链小节开发的 将一个结点 添加到空链中的代码是
        Node newNode = new Node(newEntry);
        firstNode = newNode;

        我们刚刚写的在链的开头添加结点的代码是
        Node newNode = new Node(newEntry);
        newNode.next = firstNode;
        firstNode = newNode;

    为什么当链空时，这条语句也是正确的。
        答：当链空时仅仅只是对变量赋值，并没有使用该变量。

    4，在前面这个toArray()的定义中，while语句使用
    逻辑表达式(index < numberOfEntries) && (currentNode != null) 来控制循环。
    index 和 currentNode这两个值都测试有必要吗？解释答案。
        答：通常而言，这两个条件是同时满足的，因此在进行条件检查时并不需要全部检查，
        但是，出于在代码运行时的健壮性考虑，我们需要做好条件的检查工作，防止意外情况的发生。

    5，如果前一个方法contains中的currentNode变为null，当包非空时方法返回什么值？
        答：返回false。

    6，当包为空时，跟踪方法contains的执行，结果是什么？
        答：返回false。

    7，从有5把椅子的链中删除第一把椅子需要的步骤是什么？
        答：
            a，向老师要到第一把椅子的地址
            b，将写了第二把椅子的地址交给老师
            c，将第一把椅子放回走廊

    8，从有5把椅子的链中删除第三把椅子需要的步骤是什么？
        答：
            a，向老师要到第一把椅子的地址
            b，找到第三把椅子的地址
            c，让坐在第一把椅子上的同学坐到第三把椅子上
            d，将写了第二把椅子的地址交给老师
            e，将第一把椅子放回走廊

    9，不调用getReferenceTo方法，remove方法能调用contains方法原来的定义吗？
        答：不可以，contains的定义只是返回了是否包含元素，但是并没有返回所包含元素的结点信息。

    10，修改contains方法的定义，以便它调用私有方法getReferenceTo。

    11，修改方法getReferenceTo的定义，
        以便它使用 计数器 和 entryNumber 而不使用 currentNode 来控制循环。
        答：

    12，不调用getReferenceTo方法，remove方法能调用，contains方法原来的定义吗？
        答：不可以，理由同9。

    13，方法clear的下列版本是不是释放了链中所有的结点，故而得到了一个空包？解释。
        ```
            @Override
            public void clear() {
                firstNode = null;
            }
        ```
        答：并没有，只是将firstNode结点置为空，但是如果包的链表本身不为空时，
        链表本身还有相互之间的引用。
        ==>
            因此，当firstNode为null后，没有引用指向第二个结点，故系统将释放它。
            这个过程将依次进行下去，每次释放一个结点，直到整个链被释放。

    14，比较本章类LinkedBag中与第2章类ResizableArrayBag中的contains方法。
    执行时一个比另一个花费更多的时间吗？
        答：两个方法花费的时间差不多，都需要将包进行遍历，只是使用的方式不同而言。
