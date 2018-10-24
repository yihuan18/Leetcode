//反转字符串
public class ReverseString {
    public String reverseString(String s) {
        StringBuilder ss = new StringBuilder(s);
        ss.reverse();
        s = ss.toString();
        return s;
    }
}
