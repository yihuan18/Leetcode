import java.util.HashSet;
import java.util.Set;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        Set<Character> set = new HashSet<>();
        StringBuilder result = new StringBuilder("");
        int i = 0;
        while(true){
            for(String s : strs){
                if(s.equals(""))
                    return s;
                if(i >= s.length())
                    return result.toString();
                set.add(s.charAt(i));
            }
            if(set.size() != 1)
                break;
            else{
                result.append(strs[0].charAt(i));
                i++;
                set.clear();
            }
        }
        return result.toString();
    }
    public static void main(String[] args)
    {
        String[] strs = new String[]{"a"};
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String ret = longestCommonPrefix.longestCommonPrefix(strs);
        System.out.print(ret);
    }
}
