/*
Leetcode Q202 : 快乐数
编写一个算法来判断一个数是不是“快乐数”。

一个“快乐数”定义为：
对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。
如果可以变为 1，那么这个数就是快乐数。
 */
import java.util.ArrayList;
import java.util.List;

public class HappyNumber {
    public boolean isHappy(int n) {
        List<Integer> digitList = new ArrayList<>();
        int num = n;
        int total;
        do {
            total = 0;
            while (num != 0) {
                total += Math.pow(num % 10,2);
                num = num / 10;
            }
            num = total;
        }while (total != 4 && total != 1);
        return total == 1;
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        boolean ret = happyNumber.isHappy(19);
        System.out.println(ret);
    }
}
