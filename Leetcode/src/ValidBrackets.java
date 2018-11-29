/*
LeetCode Q20 : 有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。
 */
public class ValidBrackets {
    public boolean isValid(String s) {
        char left[] = new char[s.length()];
        int currentIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[')
                left[++currentIndex] = c;
            else {
                switch (c) {
                    case ')':
                        if (currentIndex < 0 || left[currentIndex] != '(')
                            return false;
                        else currentIndex--;
                        break;
                    case '}':
                        if (currentIndex < 0 || left[currentIndex] != '{')
                            return false;
                        else currentIndex--;
                        break;
                    case ']':
                        if (currentIndex < 0 || left[currentIndex] != '[')
                            return false;
                        else currentIndex--;
                        break;
                    default:
                        break;
                }
            }
        }
        if(currentIndex >= 0)
            return false;
        return true;
    }

    public static void main(String args[]){
        ValidBrackets validBrackets = new ValidBrackets();
        System.out.print(validBrackets.isValid("(]"));
    }
}
