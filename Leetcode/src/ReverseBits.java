/*
Leetcode Q190 : 颠倒二进制位
颠倒给定的 32 位无符号整数的二进制位。
 */
public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        StringBuilder bits = new StringBuilder(Integer.toBinaryString(n));
        while (bits.length() < 32) {
            bits.insert(0, '0');
        }
        System.out.println(bits);
        //reverse
        long ret = 0;
        int length = bits.length();
        int sequence = 1;
        for (int i = length - 1; i >= 0; i--) {
            if (bits.charAt(i) == '1') {
                ret += Math.pow(2, length - sequence);
            }
            sequence++;
        }

        return (int) ret;

        /*
        return Integer.reverse(n);
         */

        /*
        public int reverseBits(int n) {
        int a = 0;
		int b = n;
		for (int i = 0; i < 32; i++) {
			a <<=1;
			if((b&1)==1)
			    a++;
			b=b>>1;
		}
		return a;
    }
         */
    }

    public static void main(String args[]) {
        ReverseBits rvb = new ReverseBits();
        System.out.print(rvb.reverseBits(1));
    }
}
