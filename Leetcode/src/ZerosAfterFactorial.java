/*
Leetcode Q172 : 阶乘后的零
给定一个整数 n，返回 n! 结果尾数中零的数量。
Tip:
   当0 < n < 5时，f(n!) = 0;
   当n >= 5时，f(n!) = k + f(k!), 其中 k = n / 5（取整）
 */
public class ZerosAfterFactorial {
    public int trailingZeroes(int n) {
        if(n < 5)
            return 0;
        else
            return n/5 + trailingZeroes(n/5);
    }

    public static void main(String[] args) {
        ZerosAfterFactorial zaf = new ZerosAfterFactorial();
        System.out.println(zaf.trailingZeroes(100));
    }
}
