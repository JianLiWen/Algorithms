package array;

import java.util.ArrayList;
import java.util.List;

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
        int [] a = new int[]{3,4};
        int [] b = new int[]{};
        System.out.println(findMedianSortedArrays(a,b));
    }


    // mine-通过，耗时21ms，主要思想就是利用两个有序链表合并的思想，通过判断两个数组的大小之和奇数还是偶数，从而转换成去找第n大的数字或者第n与第n-1的平均值，需要注意的就是异常情况的处理
    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        // 两个数组中有一个数组为空，需要考虑数组只有一个的情况
        if (n1 == 0 && n2 != 0) {
            if (n2==1){
                return nums2[0];
            }
            double v1 = nums2[n2 / 2];
            double v2 = nums2[n2 / 2 - 1];
            return n2 % 2 == 0 ? (v1+v2) / 2 : v1;
        }
        if (n2 == 0 && n1 != 0) {
            if (n1==1){
                return nums1[0];
            }
            double v1 = nums1[n1 / 2];
            double v2 = nums1[n1 / 2 - 1];
            return n1 % 2 == 0 ? (v1+v2)/ 2 : v1;
        }
        int l1 = 0;
        int l2 = 0;
        // 两个数组都不为空，则去找对应的值
        List<Integer> list = new ArrayList<>();
        boolean flag = (n1 + n2) % 2 == 0 ? false : true;
        while ( l1 <= n1-1 && l2 <= n2-1  && list.size() < (n1 + n2) / 2 + 1) {
            if(nums1[l1] < nums2[l2]) {
                list.add(nums1[l1]);
                l1++;
            } else {
                list.add(nums2[l2]);
                l2++;
            }
        }

        // 需要考虑两个数组中有一个先遍历完的情况，把另一个数组接着添加
        if (l1>n1-1 && list.size() < (n1 + n2) / 2 + 1){
            for (int i=l2;i<=(n1 + n2) / 2 -l1;i++){
                list.add(nums2[i]);
            }
        }

        if (l2>n2-1 && list.size() < (n1 + n2) / 2 + 1){
            for (int i=l1;i<=(n1 + n2) / 2 -l2;i++){
                list.add(nums1[i]);
            }
        }

        System.out.println(list.get(list.size()-1)+ "----" + list.get(list.size()-2));
        if (flag){
            return list.get(list.size()-1);
        }else {
            return (list.get(list.size()-1).doubleValue() +list.get(list.size()-2).doubleValue())/2;
        }
    }
}
