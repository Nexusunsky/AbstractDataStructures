# 自测题
#### 1，执行下列语句后 栈顶 是哪个字符串？栈地 是哪个字符串？
    答：栈顶是Jill，栈底是Jim

#### 2，考虑自测题1中创建的栈定义新的空栈NameStack。
    a，写一个循环，从stringstack中出栈，并将其入栈到namestack中。

        for(i = 0; i < stringstack.size(); i++) {
            namestack.push(stringstack.pop);
        }

    b，描述当刚写的循环执行完毕，栈stringstack和namestack中的内容。
        stringstack为空
        namestack中的内容是 栈底是Jill，栈顶是jim

#### 4，使用方法，将下列每个中缀表达式转换为后缀表达式。
    答：
        abc*+
        ab*cd-/
        ab/cd-+
        ab/c+d-

#### 5，一般地，应该什么时候将 求幂运算符^ 入栈；
    答：当 发现 有^ 运算符 时就应该入栈。
        总是，^ 优先级最高。

#### 6，使用前一个算法，将下列每个 中缀表达式 表示为 后缀表达式。
    答：
        ab+cd-/
        abc-/d*
        abcd-/e*f+g^-
        abc*-def^*g*h+/

#### 7，计算如下表达式的值，其中 a=2，b=3，c=4，d=5，e=6；
    答：
        ae+bd-/ = -4
        abc*d*- = -58
        abc-/d* = -10
        ebca^*+d- = 7

        a+b*c-(c+d) = 5
        (a+e)/(b-d) = -4
        a+(b+c*d)-e/b = 23
        e-b*c^a+d = -181