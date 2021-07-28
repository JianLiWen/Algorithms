package array;

/**
 * @author wenjianli
 * @version 1.0.0
 * @ClassName 搜索插入位置
 * @Description TODO
 * @createTime 2021年07月28日 21:54:00
 */
/*
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
请必须使用时间复杂度为 O(log n) 的算法。
输入: nums = [1,3,5,6], target = 5
输出: 2
 */
public class searchInsert {
    public static void main(String[] args) {
        int[] a = new int[]{1,3,5,6};
        int target = 5;
        System.out.println(searchInsert(a,target));
    }
    // mine 一遍过，且击败100
    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while (low<=high){
            int mid = (low+high)/2;
            if (target>nums[mid]){
                low = mid+1;
            }
            if (target<nums[mid]){
                high = mid -1;
            }
            if (target==nums[mid]){
                return mid;
            }
        }
       return high +1;
    }
}
