/*
Leetcode Q75 : 颜色分类
给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，
使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
注意:
不能使用代码库中的排序函数来解决这道题。
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int zeroLastIndex = -1 ;
        int twoFirstIndex = nums.length;
        for(int i = 0 ; i < twoFirstIndex; i++){
            if(nums[i] == 0) {
                nums[i] = nums[++zeroLastIndex];
                nums[zeroLastIndex] = 0;
            }
            else if(nums[i] == 2){
                nums[i] = nums[--twoFirstIndex];
                nums[twoFirstIndex] = 2;
                i--;
            }
        }
    }

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] nums = {1,2,0};
        sortColors.sortColors(nums);
        for(int i : nums)
            System.out.print(i + " ");
    }
}
