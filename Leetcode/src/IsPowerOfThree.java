/*
LeetCode Q326 : 3的幂
给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 */
public class IsPowerOfThree {
    public boolean isPowerOfThree(int n) {
        return (n > 0 && 1162261467 % n == 0);
    }
}
