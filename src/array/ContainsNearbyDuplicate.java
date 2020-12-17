package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 存在重复元素
 * @Author: wenjianli
 * @Date: 2020/12/17 21:03
 */
/*
给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。

输入: nums = [1,2,3,1], k = 3
输出: true
 */
public class ContainsNearbyDuplicate {
    public static void main(String[] args) {
        int []nums = new int[]{1,2,3,1};
        int k = 4;
        System.out.println(containsNearbyDuplicateBest(nums,k));
    }
    // mine--暴力法
    public static  boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]==nums[j]&&(j-i)<=k){
                    return true;
                }
            }
        }
        return false;
    }

    // hashMap 思路和两数之和类似，存储索引判断
    public static  boolean containsNearbyDuplicateBest(int[] nums, int k) {
       Map<Integer,Integer> numsMap = new HashMap<>();
       for(int i=0;i<nums.length;i++){
            if(numsMap.containsKey(nums[i])&&Math.abs(i-numsMap.get(nums[i]))<=k){
                return true;
            }
            numsMap.put(nums[i],i);
       }
       return false;
    }
}
