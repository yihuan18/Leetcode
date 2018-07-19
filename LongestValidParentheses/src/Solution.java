import java.util.Map;

public class Solution {
    public int longestValidParentheses(String s) {
        int longestLength1,longestLength2;
        longestLength1 = findLongest(s,'(');
        String s_reverse = new StringBuffer(s).reverse().toString();
        longestLength2 = findLongest(s_reverse,')');
        return Math.max(longestLength1,longestLength2);
    }

    private int findLongest(String s , char mode){
        if(s == null)
            return 0;
        int ret = 0;
        int leftCount = 0;
        int rightCount = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char currentChar = s.charAt(i);
            if(mode == '(')
            {
                if(currentChar == '(')
                    leftCount++;
                else if(currentChar == ')')
                    rightCount++;
            }else {
                if(currentChar == ')')
                    leftCount++;
                else if(currentChar == '(')
                    rightCount++;
            }


            //not valid,start from next char
            if(rightCount > leftCount){
                leftCount = 0;
                rightCount = 0;
                continue;
            }//end not valid,start from next char

            //valid,start from next char
            else if(rightCount == leftCount){
                int temp = leftCount + rightCount;
                if(temp > ret)
                    ret = temp;
                continue;
            }//end valid,start from next char
        }
        return ret;
    }//end private findLongest

    public static void main(String[] args){
        Solution solution = new Solution();
        String s = "(()))())(";
        int ret = solution.longestValidParentheses(s);
        System.out.print(ret);
    }
}
