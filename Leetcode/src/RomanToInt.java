/*
Leetcode Q13 : 罗马数字转整数
罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 */
import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public int romanToInt(String s) {
        int ret = 0;
        int currentMax = 0;
        Map<Character,Integer> table = new HashMap<>();
        table.put('I',1);
        table.put('V',5);
        table.put('X',10);
        table.put('L',50);
        table.put('C',100);
        table.put('D',500);
        table.put('M',1000);
        char cs[] = s.toCharArray();
        for(int i = cs.length - 1 ; i >= 0 ; i--){
            int num = table.get(cs[i]);
            if(num < currentMax)
                ret -= num;
            else {
                ret += num;
                currentMax = num;
            }
        }
        return ret;
    }

    public static void main(String args[]){
        RomanToInt rti = new RomanToInt();
        System.out.print(rti.romanToInt(""));
    }
}
