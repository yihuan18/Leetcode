/*
Leetcode Q5: 最长回文子串
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class LongestPalindrome {
    char[] arr;
    //中心扩展算法
    public String longestPalindrome(String s) {
        if(s.length() == 0)
            return "";
        arr = s.toCharArray();
        int low = 0,high = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            int len1 = expandFromCenter(i,i);
            int len2 = expandFromCenter(i,i+1);
            int length = Math.max(len1,len2);
            if(length >= (high - low + 1)){
                low = i - (length - 1) / 2;
                high = i + length / 2;
            }
            if((high - low + 1) >= ((s.length() - i - 1)*2 + 1))
                break;
        }
        return s.substring(low,high + 1);
}

    private int expandFromCenter(int left , int right){
        int i = left , j = right;
        while(arr[i] == arr[j] && i > 0 && j < arr.length - 1){
            i--;
            j++;
        }
        if(arr[i] != arr[j]){
            i++;
            j--;
        }
        return j - i + 1;
    }

    public static void main(String[] args){
        LongestPalindrome lgpd = new LongestPalindrome();
        String ret = lgpd.longestPalindrome("jglknendplocymmvwtoxvebkekzfdhykknufqdkntnqvgfbahsljkobhbxkvyictzkqjqydczuxjkgecdyhixdttxfqmgksrkyvopwprsgoszftuhawflzjyuyrujrxluhzjvbflxgcovilthvuihzttzithnsqbdxtafxrfrblulsakrahulwthhbjcslceewxfxtavljpimaqqlcbrdgtgjryjytgxljxtravwdlnrrauxplempnbfeusgtqzjtzshwieutxdytlrrqvyemlyzolhbkzhyfyttevqnfvmpqjngcnazmaagwihxrhmcibyfkccyrqwnzlzqeuenhwlzhbxqxerfifzncimwqsfatudjihtumrtjtggzleovihifxufvwqeimbxvzlxwcsknksogsbwwdlwulnetdysvsfkonggeedtshxqkgbhoscjgpiel");
        System.out.println(ret);
    }
}
