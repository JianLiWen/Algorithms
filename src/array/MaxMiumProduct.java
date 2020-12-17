package array;

import java.util.Arrays;

/**
 * @Description: 三个数最大乘积
 * @Author: wenjianli
 * @Date: 2020/12/16 15:24
 */
/*
给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
输入: [1,2,3]
输出: 6
输入: [1,2,3,4]
输出: 24
 */
public class MaxMiumProduct {
    public static void main(String[] args) {
        int []a = new int[]{-100,-2,-3,1};
        System.out.println(maximumProduct(a));
    }

    //
    public static int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
       return  Math.max(nums[n-1]*nums[n-2]*nums[n-3],nums[0]*nums[1]*nums[n-1]);
    }

}
