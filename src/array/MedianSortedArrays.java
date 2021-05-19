package array;

/**
 * @Description:寻找两个正序数组的中位数
 * @Author: wenjianli
 * @Date: 2021/5/19 20:20
 */

/*
给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数
输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2

输入：nums1 = [1,2], nums2 = [3,4]
输出：2.50000
解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5

输入：nums1 = [], nums2 = [1]
输出：1.00000
 */
public class MedianSortedArrays {

    public static void main(String[] args) {


    }


    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 ==0 && n2 !=0){
            return n2 %2 ==0 ? (nums2[n2/2]+nums2[n2/2+1])/2 : nums2[n2/2];
        }
        if (n2 ==0 && n1 !=0){
            return n1 %2 ==0 ? (nums1[n1/2]+nums1[n1/2+1])/2 : nums1[n1/2];
        }
        return 0;
    }
}
