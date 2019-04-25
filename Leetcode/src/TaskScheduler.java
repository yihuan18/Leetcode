/*
Leetcode Q621 : 任务调度器
给定一个用字符数组表示的 CPU 需要执行的任务列表。
其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。
任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。
CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。

然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，
因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。

你需要计算完成所有任务所需要的最短时间。
 */
import java.util.Arrays;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if(n == 0)
            return tasks.length;
        //compute nums of different tasks
        int taskKindsNum = 0;
        int ret = 0;
        int taskKindsArray[] = new int[26];
        Arrays.sort(tasks);
        int count = 0;
        for(int i = 1 ; i < tasks.length ; i++){
            count++;
            if(tasks[i]!=tasks[i-1]){
                taskKindsArray[taskKindsNum++] = count;
                count = 0;
            }
        }
        taskKindsArray[taskKindsNum++] = count+1;
        int arrayEndIndex = taskKindsNum-1;
        Arrays.sort(taskKindsArray,0,taskKindsNum);
        int nums = taskKindsArray[arrayEndIndex];
        ret+=(n+1)*(nums-1)+1;
        while(arrayEndIndex > 0 && taskKindsArray[--arrayEndIndex] == nums)
            ret++;
        return Math.max(tasks.length,ret);
    }

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 1;
        TaskScheduler ts = new TaskScheduler();
        int ret = ts.leastInterval(tasks,n);
        System.out.println(ret);
    }

}
