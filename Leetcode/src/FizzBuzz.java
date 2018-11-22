/*
LeetCode Q412 : FizzBuzz
写一个程序，输出从 1 到 n 数字的字符串表示。
1. 如果 n 是3的倍数，输出“Fizz”；
2. 如果 n 是5的倍数，输出“Buzz”；
3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 */
import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> ret = new ArrayList<>();
        for(int i = 1 ; i <= n ; i ++){
            ret.add(Integer.toString(i));
        }
        for(int i = 3 ; i <= n ; i +=3){
            ret.set(i - 1,"Fizz");
        }
        for(int i = 5; i <= n ; i += 5){
            if(i % 3 == 0)
                ret.set(i - 1 , "FizzBuzz");
            else ret.set(i - 1, "Buzz");
        }
        return ret;
    }
}
