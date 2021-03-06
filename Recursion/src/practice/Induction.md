### 归纳法
20，
    如果
        t(1) = 2
        t(n) = 1 + t(n-1) 对于 n > 1;
    寻找 不由自己表示的 t(n)的表达式，使用 归纳法 证明你的结论是正确的。
证明：
    考察：
        t(1) = 2
        t(2) = 1 + t(1) = 3
        t(3) = 1 + t(2) = 4
        t(4) = 1 + t(3) = 5
   猜想 n>=1 t(n) = 1 + n;
   证明：
    在n = 1 时 ，t(1) = 1 + 1 = 2;
    在n = k 时
        t(1) = 2
        t(2) = 1 + t(1) = 3
        t(3) = 1 + t(2) = 4
        ...
        t(k) = 1 + t(k-1)
        t(1) + t(2) + t(3) + ... + t(k) = t(1) + (t(2) + 1) + (t(3) + 1) + ... + (t(k-1) + 1)
        t(k) = k - 1 + 2 = 1 + k;
        可知对于 n>=1 的k 存在有 t(k) = 1 + k;
        证得：
            对于 n >= 1 有  t(n) = 1 + n; 成立；
21，
    如果
        t(1) = 1
        t(n) = 2 * t(n-1) 对于 n > 1;
    寻找 不由自己表示的 t(n)的表达式，使用 归纳法 证明你的结论是正确的。
证明：
        t(1) = 1
        t(2) = 2 * t(1) = 2
        t(3) = 2 * t(2) = 4
        t(4) = 2 * t(3) = 8
    假设， 对于 n > 1 存在有
        t(n) = 2 ^ (n-1);
    证明：
        在t = 1;时，t(1) = 1;
        t(1) = 1
        t(2) = 2 * t(1) = 2
        t(3) = 2 * t(2) = 4
        t(4) = 2 * t(3) = 8
        ...
        t(k) = 2 * t(k-1)

        t(1) * t(2) * t(3) * t(4) * ... * t(k)
        = 1 * (2*t(1)) * (2*t(2)) * ... *(2*t(k-1))
        t(k) = 1 * 2 ^ (k-1) = 2 ^(k-1);
    可知：对于n > 1 时 存在有k ，满足
        t(k) = 2 ^(k-1);
    证得；





















