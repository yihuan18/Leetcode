//把0放在数组的最后，并且不改变数组的相对顺序
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int nonZero = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] != 0) {
                nums[nonZero] = nums[i];
                nonZero++;
            }
        }

        for(int j = nonZero ; j < nums.length ; j++)
            nums[j] = 0;
    }

    public static void main(String[] args){
        MoveZeros moveZeros = new MoveZeros();
        int[] nums = {0,1,0,3,12};
        moveZeros.moveZeroes(nums);
        for(int i : nums)
            System.out.print(i + " ");
    }
}
