/*
Leetcode Q34 : 在排序数组中查找元素的第一个和最后一个位置
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
你的算法时间复杂度必须是 O(log n) 级别。
如果数组中不存在目标值，返回 [-1, -1]。
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)
            return new int[]{-1,-1};
        int low = 0,high = nums.length-1;
        int mid = 0;
        while(low <= high){
            mid = (low + high)/2;
            if(nums[mid] < target)
                low = mid + 1;
            else if(nums[mid] > target)
                high = mid - 1;
            else break;
        }
        low = mid;
        high = mid;
        if(nums[low]!=target)
            return new int[]{-1,-1};
        while(low >= 1 && nums[low - 1] == target)
            low--;
        while(high < (nums.length-1) && nums[high+1] == target)
            high++;
        return new int[]{low,high};
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        int[] ret;
        ret = searchRange.searchRange(new int[]{1,4},4);
        for(int i : ret)
            System.out.println(i);

    }
}
