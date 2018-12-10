/*
Leetcode Q334 : 递增的三元子序列
给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
数学表达式如下:
如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 */
public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        //维护一个二元组(first,second)，记录第i个元素之前的“最小”递增二元子序列
        //（对后续元素的要求最低如[5,6,2,3,4]会更新[5,6]为[2,3]此时只要后续满足大于3就可以）
        int first = Integer.MAX_VALUE,second = Integer.MAX_VALUE;
        for(int i : nums){
            if(i < first)
                first = i;
            else if(i  > first && i < second){
                second = i;
            }
            else if(i > second)
                return true;
        }
        return false;
    }

    public static void main(String[] args){
        IncreasingTriplet increasingTriplet = new IncreasingTriplet();
        System.out.println(increasingTriplet.increasingTriplet(new int[]{0,4,2,1,0,-1,-3}));
    }

}
