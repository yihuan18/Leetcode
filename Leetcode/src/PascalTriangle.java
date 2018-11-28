/*
LeetCode Q118 :  杨辉三角
给定一个非负整数numRows，生成杨辉三角的前numRows行。
在杨辉三角中，每个数是它左上方和右上方的数的和。
 */
import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for(int i = 0 ; i < numRows ; i++){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            if(i == 0) {
                ret.add(list);
                continue;
            }
            //according to last array , fill current array
            List<Integer> last = ret.get(i - 1);
            if(last.size() > 1)
                for(int j = 0 ; j < last.size() - 1 ; j++){
                    list.add(last.get(j) + last.get(j+1));
                }
            list.add(1);
            ret.add(list);
        }
        return ret;
    }

    public static void main(String args[]){
        PascalTriangle pascalTriangle = new PascalTriangle();
        List<List<Integer>> ret;
        ret = pascalTriangle.generate(5);
        System.out.print(ret);
    }
}
