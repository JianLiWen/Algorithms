package array;

/**
 * @Description:删除有序数组中的重复项
 * @Author: wenjianli
 * @Date: 2021/5/29 14:04
 */
/*
给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
输入：nums = [1,1,2]
输出：2, nums = [1,2]
解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。

输入：nums = [0,0,1,1,1,2,2,3,3,4]
输出：5, nums = [0,1,2,3,4]
解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,2,3,3,4,5,5,6,7};
        System.out.println("最大长度"+removeDuplicates(nums));
    }

    // mine-通过 0ms,击败百分百
    public static int removeDuplicates(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int index = nums[0];
        int afterLength = 0;
        for (int i=1;i<nums.length;i++){
            if (index<nums[i]){
                afterLength++;
                index = nums[i];
                nums[afterLength] = nums[i];
            }
        }
        return afterLength+1;
    }
}
