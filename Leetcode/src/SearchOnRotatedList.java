/*
Leetcode Q33 : 搜索旋转排序数组
假设按照升序排序的数组在预先未知的某个点上进行了旋转。
( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
你可以假设数组中不存在重复的元素。
你的算法时间复杂度必须是 O(log n) 级别。
 */
public class SearchOnRotatedList {
    public int search(int[] nums, int target) {
        //如果中间的数小于最右边的数，则右半段是有序的，
        // 若中间数大于最右边数，则左半段是有序的，
        // 我们只要在有序的半段里用首尾两个数组来判断目标值是否在这一区域内，
        // 这样就可以确定保留哪半边了
        int left = 0,right = nums.length - 1;
        int mid = 0;
        while(left <= right){
            mid = (left+right)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] < nums[right]){
                if(target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else right = mid - 1;
            }
            else {
                if(target < nums[mid] && target >= nums[left])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchOnRotatedList sor = new SearchOnRotatedList();
        int ret = sor.search(new int[]{4,5,6,7,0,1,2},3);
        System.out.println(ret);
    }
}
