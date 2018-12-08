/*
Leetcode  Q3 : 无重复字符的最长子串
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        String lastSubString = "";
        for (int i = 0; i < s.length(); i++) {
            char current_char = s.charAt(i);
            if (i == 0) {
                maxLength = 1;
                lastSubString = s.substring(0, 1);
            }
            int index = 0;
            index = lastSubString.indexOf(current_char);
            if (index == -1) {
                lastSubString += current_char;
            } else {
                lastSubString = lastSubString.substring(index + 1);
                lastSubString += current_char;
            }
            if (maxLength < lastSubString.length())
                maxLength = lastSubString.length();
        }
        return maxLength;
    }

    /*滑动窗口解法
    public int lengthOfLongestSubstring(String s) {
        int stIdx = 0, maxLen = 0;
        int arr[] = new int[128];
        for(int i=0;i<s.length();i++){
            stIdx = Math.max(arr[s.charAt(i)],stIdx);
            maxLen = Math.max(maxLen, i-stIdx+1);
            arr[s.charAt(i)] = i+1;
        }
        return maxLen;
    }
     */

    public static void main(String[] args){
        LengthOfLongestSubstring lols = new LengthOfLongestSubstring();
        int ret = lols.lengthOfLongestSubstring("pwwkew");
        System.out.println(ret);
    }
}
