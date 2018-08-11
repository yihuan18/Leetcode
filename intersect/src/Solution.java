import java.util.Arrays;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] ret = new int[nums1.length];
        int count = 0;
        int i = 0 , j = 0;

        while((i < nums1.length) && (j < nums2.length)){
            if(nums1[i] < nums2[j])
                i++;
            else if(nums1[i] > nums2[j])
                j++;
            else {
                ret[count] = nums1[i];
                count++;
                i++;
                j++;
            }
        }

        int[] intersectNum = new int[count];
        System.arraycopy(ret,0,intersectNum,0,count);

        return intersectNum;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums1 = {1,2,2,3};
        int[] nums2 = {1,3};
        int[] nums3;
        nums3 = solution.intersect(nums1,nums2);
        for(int i : nums3)
            System.out.print(i + " ");
    }
}
