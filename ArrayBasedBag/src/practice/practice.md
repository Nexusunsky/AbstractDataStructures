1，为什么类ArrayBag中的方法getIndexOf和removeEntry()是私有的不是共有的？
    答：这两个方法是实现ADT包中接口的实现细节，是可以变化的部分，不应该暴露出来。

2，为ADT包实现方法replace方法，用一个给定对象替换当前包中的对象，并返回原始对象。
    public T replace(int index, T replacement);

3，修改2.1.7节的方法clear定义。以便更有效率且仅调用checkInitialization()方法。
    答：见代码 ArrayBag。

4，修改2.1.7节的避免重复工作中给出的方法remove()，以便从包中删除一个随机项。这个修改会影响到类ArrayBag中的其他方法吗？
    答：删除随机项，会影响到ArrayBag中的其他方法，因为，我们在实现ArrayBag时，会使用Bag中的最后一项填充被删除的项。

5，为类ArrayBag定义方法removeEvery，从包中删除给定项的所有出现。
    答：public boolean removeEvery(T entry);

6，类ArrayBag的实例有固定大小，而ResizableArrayBag的实例则没有。
给出一些例子，如果包的大小是
    a，固定的
    b，可变的，
则包是合适的。
    答：

7，假定想定义类PileOfBooks来实现前一章项目2中描述的接口。包是表示一堆书的合理接口吗？
    答：包的不是表示堆stack的接口，stack的特点是有序的先进后出（FILO），但是包是无序的。

8，现有ResizableArrayBag的实例myBag，假定myBag的初试容量是10。
    a，向myBag中添加了145项后
    b，向myBag中添加20项后
数组bag的长度是？
    答：
    a，myBag的长度增长为10,20,40,80,160。那么在添加145项后的长度不大于160。
    b，向myBag添加20项后，maBag的长度会倍增为40。

9，

10，假定包中含有Comparable对象，例如字符串。一个Comparable对象属于实现了标准接口
Comparable<T>的一个类，所以有方法compareTo。为类ArrayBag实现下列方法：
    a，返回包中最小对象的方法getMin
    b，返回包中最大对象的方法getMax
    c，删除并返回包中最小对象的方法removeMin
    d，删除并返回包中最大对象的方法removeMax
    答：
    public T getMin();
    public T getMax();
    public T removeMin();
    public T removeMax();

11，假定包中含有Comparable对象，如前一个练习中所描述的那样。
为类ArrayBag定义一个方法，返回由小于某个给定项的项组成的新包。
public IBag<T> getAllLessThan(Comparable<T> anObject);
确保你的方法不会影响到原始包的状态。

12，为类ArrayBag定义equals方法，当两个包的内容相同是返回真。
注意，两个相等的包应含有相同个数的项，每个项出现在每个包中个数应该相等，每个数组中的项的次数是无关的。
答：

13，类ResizableArrayBag有一个数组，当向包中添加对象时其大小增大。
修改这个类，使得当从包中删除对象时，它的数组还可以缩小。
完成这个任务需要添加两个新的私有方法，如下：
    第一个新方法检查是否应该减少数组的大小：
        private boolean isTooBig();
        如果包中的项数小于数组大小的一半且数组的大小大于20，这个方法返回真。

    第二个新方法创建一个新数组，其大小是当前数组大小的3/4，且数组的大小大于20。
        private void reduceArray();
实现这两个方法，然后使用它们来定义两个remove方法。

14，考虑前一个练习中描述的两个私有方法。
    a，方法isTooBig需要数组的大小大于20。如果没有这个要求可能会发生什么问题？
    b，方法reduceArray与方法doubleCapacity不同，并不是倍减。
    如果让数组大小减少一半而不是3/4，可能会出现什么问题。
答：
    a,如果数组的大小小于20时，进行增删操作，会频繁的发生数组的创建和销毁，影响到程序性能。
    b,减少一半会导致，数组中容易出现接近一半的内存空置的现象，不利于资源的利用。

