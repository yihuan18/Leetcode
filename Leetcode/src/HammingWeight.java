/*
Leetcode Q191 : 位1的个数
编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 */
public class HammingWeight {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    /*
    public int hammingWeight(int n) {
      int count =0;
    while (0!=n)
    {
       count++;
       n=n&(n-1);
    }
    return count;

    }
     */
}
