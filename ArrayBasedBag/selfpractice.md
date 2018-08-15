自测题：
1，为让空闲的椅子不再空闲而移动学生的方式有什么优点？
    答：有利于为新进来的学生安排座位。

2，让空闲下来的椅子空着有什么优点？
    答：增大资源利用率，为实际的需要安排位置。    

3，如果学生想逃课，哪个学生逃课不会迫使其他的人换椅子？
    答：最后一个    

4，在toArray方法中，entryNumber的值一般等于arrayBag.length吗？
    答：不等于，entryNumber可以理解为教室内学生的数量，而arrayBag.length可以理解为教室内位置的数量。    

5，假定前面的toArray方法让新数组result的长度与数组bag相同。客户如何得到返回的数组中的项树？
    答：myBag.toArray().length;

6，假定前面的toArray方法返回的数据bag，而不是返回像result这样的新数组。
   如果myBag是含5个项的包，则下列语句对数组bag和域entryNumber的影响是什么？
   Object[] bagArray = myBag.toArray();
   bagArray[0] = null;    
   答：数组bag的第一项置空了，不再引用任何数据对象，而entryNumber的值并不变化。

7，如果调用Arrays.copyof，则方法toArray的方法体中可以含有一个return语句，修改方法toArray。
```
    @Override
    public T[] toArray() {
        return Arrays.copyOf(arrayBag, entryNumber);
    }  
```    

9，方法contains可以调用getFrequencyOf而不是执行一个循环，即你可以想下面这样定义方法：比较这个方法和前一个方法的优缺点；
```
        @Override
        public boolean contains(final T anEntry) {
            checkInitialization();
            return getFrequencyOf(anEntry) > 0;
        }
```     
   答：
      优点：复用了部分代码逻辑更加易于维护
      缺点：造成了过多次数无意义的循环开销，应该使用可变次数的查找方式；

10，修改方法clear的定义，让它不调用isEmpty()
```
    @Override
    public void clear() {
        while (remove() != null) {
        }
    }
```    

11，用下列语句
    entryNumber = 0 
    替换上一段的clear 定义中的循环，有什么缺点？


12，为什么方法remove将从数组bag中删除的项替换为null
    答：让数组不在引用已经从bag里面删除的项，并释放相应的资源，让虚拟机回收已经被删除的对象。 

13，前一个remove方法删除数组bag中的最后一项。删除其他项为什么会更难完成。
    答：

14，remove的前一个定义中的return语句能写成下面这样吗？
    a, return result.equals(anEntry);
    b, return != null;                     
    答：

15，ArrayBag中的数组bag含有aBag中的项。
    如果数组含有字符串 "A"，"A"，"B"，"A"，"C"。
    为什么aBag.remove("B")将数组内容的改变为 "A"，"A"，"C"，"A"，null。
    而不是 "A"，"A"，"A"，"C"，null。或者"A"，"A"，null，"A"，"C"。 
    答：
    
16，在方法getIndexOf的return语句之前，能添加什么assert语句来表示方法能够返回的可能值。
    答：
    
17，修改方法getIndexOf的定义，让它不使用布尔值。
    答：


18，考虑下列语句定义的字符串数组：
    String[] text = {"cat", "dog", "bird", "snake"}  
    为数组text增大5个元素的容量且不改变当前内容的Java语句是什么？
    答：
    text = Arrays.copy(text, text.length + 5);
    
    
19，考虑字符串数组text。如果放到这个数组中的字符串的个数小于它的长度（容量），你如何减少数组的长度而不改变它的当前内容？
    假定字符串的个数保存在变量size中；      
    答： 
       String[] temp = new String[size]; 
       for( i = 0, i < size, i++ ) {
           temp[i] = text[i];
       }
 
20，可以添加到类ResizableArrayBag 中，用给定数组的内容来初始化包的构造方法是什么？
    答：
    ```
        public ResizableArrayBag(T[] origin) {
            int size = origin.length;
            if (size <= MAX_CAPACITY) {
                this.arrayBag = Arrays.copyOf(origin, size);
                this.entryNumber = 0;
                this.initialized = true;
            } else {
                throw new IllegalStateException("Attempt to create a big object.");
            }
        }
    ```
    
21，在前一个问题描述的构造方法的定义中，需要将参数数组中的项复制到数组bag中吗？或者一条简单的赋值语句( bag = contents)就足够了？
    答：
    需要将参数数组中的项赋值到数组bag中，否则将导致构造出来的Bag中引用数组对象的逃逸。

22，使用数组来组织数据的好处是什么？坏处是什么？
    答：数组会开辟一段连续的内存空间来存放数据，对于内存的利用率高。
    但缺点是不太灵活。    
          