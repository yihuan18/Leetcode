import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
/*
 Leetcode Q400 : 第n个数字
 */
public class Solution {
    public int findNthDigit(int n) {
        int ret;
        char digit;
        int numLength = 0;
        int currentTotal = 0;
        int lastTotal = 0;
        while(n > currentTotal){
            lastTotal = currentTotal;
            numLength++;
            currentTotal += (Math.pow(10 , numLength) - Math.pow(10 , numLength-1)) * numLength;
        }
        int numSeq = (n - lastTotal)/numLength;
        int digitSeq = (n - lastTotal)%numLength;
        int targetNum1 = (int)Math.pow(10 , numLength-1) - 1 + numSeq;
        int targetNum2 = targetNum1 + 1;
        if(digitSeq == 0)
            digit = Integer.toString(targetNum1).charAt(numLength-1);
        else {
            String s = Integer.toString(targetNum2);
            digit = s.charAt(digitSeq - 1);
        }
        ret = digit - '0';
        return ret;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int result = solution.findNthDigit(11);
        System.out.print(result);
    }
}
