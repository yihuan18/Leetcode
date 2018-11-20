/*
LeetCode Q155 : 最小栈
设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
push(x) -- 将元素 x 推入栈中。
pop() -- 删除栈顶的元素。
top() -- 获取栈顶元素。
getMin() -- 检索栈中的最小元素。
 */
import java.util.ArrayList;
import java.util.List;

public class MinStack {
    private List<Integer> stack;
    private int stackNum;
    private int min;
    private int minCount;
    public MinStack() {
        stack = new ArrayList<>();
        stackNum = 0;
        min = Integer.MAX_VALUE;
        minCount = 0;
    }

    public void push(int x) {
        if(stack.size() > stackNum)
            stack.set(stackNum,x);
        else stack.add(x);
        stackNum++;
        if(x < min) {
            min = x;
            minCount = 1;
        }
        else if(x == min)
            minCount++;
    }

    public void pop() {
        stackNum--;
        if(stack.get(stackNum) == min)
            minCount--;
        if(minCount == 0)
            setMin();
    }

    public int top() {
        return stack.get(stackNum - 1);
    }

    public int getMin() {
        if(minCount > 0)
            return min;
        else {
            setMin();
            return min;
        }
    }

    private void setMin(){
        minCount = 0;
        min = Integer.MAX_VALUE;
        for(int i = 0 ; i < stackNum ; i++){
            if(stack.get(i) < min){
                min = stack.get(i);
                minCount = 1;
            }
            else if(stack.get(i) == min){
                minCount++;
            }
        }
    }

    /*
    Stack<Integer> stack;
    Stack<Integer> stack_res;
    public MinStack() {
        stack= new Stack<>();
        stack_res= new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(stack_res.isEmpty()||stack_res.peek()>=x)
            stack_res.push(x);
    }

    public void pop() {
        if (stack.pop().equals(stack_res.peek())) {
            stack_res.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stack_res.peek();
    }
     */
}
