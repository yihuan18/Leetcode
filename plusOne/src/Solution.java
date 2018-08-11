public class Solution {
    public int[] plusOne(int[] digits) {
        int addition = 0;
        for(int i = digits.length - 1 ; i >= 0 ; i--){
            addition = (digits[i] + 1)/10;
            digits[i] = (digits[i] + 1)%10;
            if(addition == 0)
                break;
        }
        if(addition == 0)
            return digits;
        else{
            int[] ret = new int[digits.length + 1];
            ret[0] = 1;
            System.arraycopy(digits,0,ret,1,digits.length);
            return ret;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] ret;
        int[] digits = {1,2,3};
        ret = solution.plusOne(digits);
        for(int i:ret)
            System.out.print(i + " ");
    }
}
