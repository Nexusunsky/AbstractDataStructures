1，为什么类ArrayBag中的方法getIndexOf和removeEntry()是私有的不是共有的？
    答：这两个方法是实现ADT包中接口的实现细节，是可以变化的部分，不应该暴露出来。

2，为ADT包实现方法replace方法，用一个给定对象替换当前包中的对象，并返回原始对象。
    public T replace(int index, T replacement);

3，修改2.1.7节的方法clear定义。以便更有效率且仅调用checkInitialization()方法。
    答：

4，修改2.1.7节的避免重复工作中给出的方法remove()，以便从包中删除一个随机项。这个修改会影响到类ArrayBag中的其他方法吗？
