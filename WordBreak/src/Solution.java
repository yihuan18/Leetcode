import java.util.*;

public class Solution {
    int[] v;
    public boolean wordBreak(String s, List<String> wordDict) {
        v = new int[s.length()];
        for(int i = 0 ; i < s.length() ; i++)
            v[i] = 0;

        wordDict.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2.length()-o1.length());
            }
        });

        return  OPT(s , wordDict , 0);
    }


    boolean OPT(String s , List<String> wordDict , int index){
        if(v[index] == 1)
            return true;
        else if(v[index] == -1)
            return false;

        for(String word : wordDict){
            int word_length = word.length();
            if(word_length > s.length())
                continue;
            if(word.equals(s.substring(0,word_length))){
                if(word.length() == s.length()){
                    v[index] = 1;
                    return true;
                }
                boolean ret = OPT(s.substring(word.length()) , wordDict , index + word_length);
                if(ret){
                    v[index] = 1;
                    return true;
                }

            }
        }
        v[index] = -1;
        return false;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("a");
        wordDict.add("aa");
        wordDict.add("aaa");
        wordDict.add("aaaa");
        wordDict.add("aaaaa");

        boolean ret = solution.wordBreak(s , wordDict);
        System.out.print(ret);
    }
}
