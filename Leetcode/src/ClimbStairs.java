/*
Leetcode Q70 : 爬楼梯
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {
    Map<Integer,Integer> steps = new HashMap<>();
    public int climbStairs(int n) {
        if(steps.containsKey(n))
            return steps.get(n);
        else if(n == 0){
            steps.put(0,0);
            return 0;
        }
        else if(n == 1){
            steps.put(1,1);
            return 1;
        }
        else if(n == 2){
            steps.put(2,2);
            return 2;
        }
        else {
            int a,b;
            if(steps.containsKey(n-1))
                a = steps.get(n-1);
            else {
                a = climbStairs(n-1);
                steps.put(n-1,a);
            }
            if(steps.containsKey(n-2))
                b = steps.get(n-2);
            else {
                b = climbStairs(n-2);
                steps.put(n-2,b);
            }
            return a + b;
        }
    }

    /* bottom up
    public int climbStairs(int n) {
        if(n==0||n==1||n==2){
            return n;
        }
        int[] arr = new int[n+1];
        arr[1]=1;
        arr[2]=2;
        for (int i = 3; i < arr.length; i++) {
            arr[i]=arr[i-2]+arr[i-1];
        }
        return arr[n];
    }
     */
}
