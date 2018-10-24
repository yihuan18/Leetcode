import java.util.*;
//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
public class FirstUniqueChar {
    public int firstUniqChar(String s) {
        int hashTable[] = new int[256];
        for(int i = 0 ; i < s.length() ; i++){
            hashTable[s.charAt(i)]++;
        }
        for(int i = 0 ; i < s.length() ; i++){
            if(hashTable[s.charAt(i)] == 1)
                return i;
        }
        return -1;
    }
    public static void main(String[] args){
        FirstUniqueChar firstUniqueChar = new FirstUniqueChar();
        int ret = firstUniqueChar.firstUniqChar("loveleetcode");
        System.out.print(ret);
    }
}
