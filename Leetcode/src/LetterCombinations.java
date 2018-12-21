/*
LeetCode Q17 : 电话号码的字母组合
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
import java.util.*;

public class LetterCombinations {
    private int index;
    private Character[][] digitsAlphabetMapping;
    public LetterCombinations(){
        index = 0;
        digitsAlphabetMapping = new Character[][]{
                {}, {},
                {'a', 'b', 'c'},    // index = 2
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}};
    }
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if(digits.length() == 0)
            return ret;

        Character currentDigit = digits.charAt(index);
        Character[] currentAlphabet = digitsAlphabetMapping[currentDigit-'0'];
        if(index == (digits.length() - 1)) {
            for(Character c : currentAlphabet){
                ret.add(c.toString());
            }
            return ret;
        }
        index++;
        List<String> last = letterCombinations(digits);
        for(String s : last){
          for(Character add : currentAlphabet){
              String temp;
              temp = add + s;
              ret.add(temp);
          }
        }
        return ret;
    }

    public static void main(String[] args){
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> ret;
        ret = letterCombinations.letterCombinations("23");
        System.out.println(ret);
    }
}
