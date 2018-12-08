/*
Leetcode Q49 : 字母异位词分组
给定一个字符串数组，将字母异位词组合在一起。
字母异位词指字母相同，但排列不同的字符串。
 */
import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(int i = 0 ; i < strs.length ; i++){
            char temp[] = strs[i].toCharArray();
            Arrays.sort(temp);
            String s = new String(temp);
            List<String> group = map.getOrDefault(s,new ArrayList<>());
            group.add(strs[i]);
            map.put(s,group);
        }
        for(String s : map.keySet())
            ret.add(map.get(s));
        return ret;
    }

    public static void main(String[] args){
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> ret = new ArrayList<>();
        ret = groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(ret);
    }
}
