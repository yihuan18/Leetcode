/*
Leetcode Q461 : 汉明距离
两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
给出两个整数 x 和 y，计算它们之间的汉明距离。
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
    /*
    public int hammingDistance(int x, int y) {
        int count = 0;
        while(x > 0 || y > 0){
            if((x & 1 ) != (y & 1)){
                count ++;
            }
            x = x >>> 1;
            y = y >>> 1;
        }
        return count;
    }
     */
}
