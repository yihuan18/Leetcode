/*
Leetcode Q22 : 括号生成
给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 */
import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        if(n == 0)
            return ret;
        char[] order = new char[2*n];
        generate(n,n,order,0,n,ret);
        return ret;
    }

    public void generate(int left,int right,char[] order,int level ,int n,List<String> ret){
        //所剩余的左括号数一定比右括号数少
        char[] current;
        if(left == right){
            current = new char[1];
            current[0] = '(';
        }else if(left > 0){
            current = new char[2];
            current[0] = '(';
            current[1] = ')';
        }else {
            current = new char[1];
            current[0] = ')';
        }

        for(char c : current){
            order[level] = c;
            if(level == (2*n-1))
                ret.add(new String(order));
            else{
                if(c == '(')
                    generate(left-1,right,order,level+1,n,ret);
                else generate(left,right-1,order,level+1,n,ret);
            }
        }
    }

    public static void main(String[] args){
        GenerateParenthesis gp = new GenerateParenthesis();
        List<String> ret = gp.generateParenthesis(3);
        System.out.println(ret);
    }
}
