作为设计原则：
    抽象 要求 关注于 什么(what) 而不是 如何(how)
    在设计一个ADT 并最终设计一个类时，使用数据抽象 将关注焦点集中 在 处理数据的能力上而不必担心如何去处理数据

数据：
数据类型 是 一组值 及 使用某种特定的程序语言定义的值上的操作
抽象数据类型 ADT 是 概念层面上定义的一组值 及这些值上操作的规格说明，独立于任何程序设计语言
数据结构 使用使用一种程序设计语言实现的 ADT 

集合：
对象分组：集合 是 一种对象，它 将 其他对象 组成 一组
具体而言，典型的集合 能够 让 客户 添加，删除，获取及查询 它组合的对象。不同的集合 用于 不同的目的。
集合 是 一个抽象 ，且是一个 抽象数据类型 ADT，但ADT不一定是集合。

类的设计决策：当特殊条件出现时
    1，假定无效的情形不能发生，客户需要遵守的限制，由客户在调用前检查前置条件是否满足
    2，忽略无效的情形，在给定无效数据时将没有任何行为
    3，猜测客户的意图，与前一个选择一样
    4，返回一个表示问题的值，当给定数据无效时，返回null
    5，返回一个布尔值，表示操作的成功或失败
    6，抛出一个异常
    
包：
包 是 没有特定次序的对象 的有限集合，这些对象具有相同或相关的数据类型。包可以含有重复项。
 1，仅仅是 含有项，
 2，但没有 按某种方式规定项的次序
 3，也允许有重复的项
 
包的行为：
 1，有限集合：得到当前包中的项数
 2，相关行为：查看包是否为空
 3，添加和删除对象：
         a, 将给定对象添加到包
         b, 从包中删除一个未指定的对象
         c, 删除具体对象的一次出现
         d, 从包中删除所有对象

注明：抽象数据类型 描述了 独立于程序设计语言的数据组织方式，
CRC 类责任协作卡：
        Bag：
职责：
    得到当前包中的项数
    查看包是否为空
    将给定对象添加到包中
    从包中删除一个未指定的对象
    从包中删除一个具体对象的一次出现
    从包中删除所有对象
    统计包中某个对象的个数
    测试包是否含有某个对象
    查看包中的所有对象
协作：
    包能够含有的对象的类    

----------------------------
Bag
----------------------------    
+getCurrentSize(): integer
+isEmpty(): boolean
+add(newEntry: T): boolean    
+remove(): T
+remove(anEntry: T): boolean
+clear(): void
+getFrequencyOf(anEntry: T): integer
+contains(anEntry: T): integer
+toArray(): T[]    
    

总结：
    1，抽象数据类型 ADT 是数据集 和数据上操作的规格说明。这个说明不指明实现细节，并且是任何程序设计语言无关的。
    2，使用数据抽象设计 ADT 时，关注的点在于想要对数据实现的操作而忽略实现的细节。
    3，ADT 的意义在于实现了 数据 及其操作的封装。
    4，包 是 无特殊次序 的 项 的 有限集合
    5，集合是保存一组其他对象的对象，并且不含有重复项
