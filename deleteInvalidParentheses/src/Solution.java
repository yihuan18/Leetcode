import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    int removeCount = 1;
    public List<String> removeInvalidParentheses(String s) {
        List<String> ret = new ArrayList<>();
        Map<String,Integer> ret_map = new HashMap<>();
        ret_map.put(s,1);

        while(removeCount != 0){
            List<String> ret_backup = new ArrayList<>();
            for(String s_temp : ret_map.keySet()){
                List<String> remove_ret;
                remove_ret = removeOneCharacter(s_temp);
                ret_backup.addAll(remove_ret);
            }
            ret_map.clear();
            for(String s_temp : ret_backup)
                ret_map.put(s_temp,1);
        }
        for(String s1 : ret_map.keySet())
            ret.add(s1);
        return ret;
    }

    private List<String> removeOneCharacter(String s){
        List<String> ret_temp = new ArrayList<>(); //store remove one character, if no change , return original
        int[] indexStack = new int[s.length()];
        int[] indexStackLeft = new int[s.length()];
        int[] indexStackLeft_Right = new int[s.length()];
        int stackTopLeft = 0;
        int stackTop = 0;
        int latestRemovalIndexRight = -1;
        int latestRemovalIndexLeft = -1;

        for(int i = s.length() - 1 ; i >= 0 ; i--){
            char currentChar = s.charAt(i);
            if(currentChar != '(' && currentChar != ')')
                continue;
            if(currentChar == '('){
                indexStackLeft[stackTopLeft] = i;
                stackTopLeft++;

                if(stackTop == 0){
                    for(int j = stackTopLeft - 1 ; j >= 0 ;j--){
                        StringBuilder stringBuilder = new StringBuilder(s);
                        stringBuilder.deleteCharAt(indexStackLeft[j]);
                        ret_temp.add(stringBuilder.toString());
                    }
                    removeCount = 1;
                    return ret_temp;
                }
                else if(stackTop != 0){
                    stackTop--;
                    indexStackLeft_Right[stackTopLeft-1] = indexStack[stackTop];
                    latestRemovalIndexRight = indexStack[stackTop];
                    latestRemovalIndexLeft = i;
                }

            }
            else {  //")"
                indexStack[stackTop] = i;
                stackTop++;
            }
        }

        if(stackTop!=0){
            for(int j = stackTop - 1 ; j >= 0 ; j--){
                if(indexStack[j] < latestRemovalIndexLeft){
                    StringBuilder stringBuilder = new StringBuilder(s);
                    stringBuilder.deleteCharAt(indexStack[j]);
                    ret_temp.add(stringBuilder.toString());
                    removeCount = 1;
                    return ret_temp;
                }else{
                    for(int left_top = stackTopLeft - 1; left_top >= 0; left_top--){
                        if(indexStackLeft_Right[left_top] < indexStack[0]){
                            indexStack[stackTop] = indexStackLeft_Right[left_top];
                            stackTop++;
                        }
                    }
                    for(int jj = stackTop - 1 ; jj >= 0 ; jj--){
                        StringBuilder stringBuilder = new StringBuilder(s);
                        stringBuilder.deleteCharAt(indexStack[jj]);
                        ret_temp.add(stringBuilder.toString());
                    }
                    removeCount = 1;
                    return ret_temp;
                }
            }
        }
        removeCount = 0;
        ret_temp.add(s);
        return ret_temp;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String s = ")(()c))(";
        List<String> result;
        result = solution.removeInvalidParentheses(s);
        for(String temp:result){
            System.out.println(temp);
        }
    }
}
