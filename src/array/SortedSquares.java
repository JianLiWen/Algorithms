package array;

import java.util.Arrays;

/**
 * @Description: 有序数组的平方
 * @Author: wenjianli
 * @Date: 2020/12/12 11:45
 */

/*
给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
输入：[-4,-1,0,3,10]
输出：[0,1,9,16,100]

输入：[-7,-3,2,3,11]
输出：[4,9,9,49,121]
 */
public class SortedSquares {
    public static void main(String[] args) {
        int []nums = new int[]{-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquaresBetter(nums)));
    }

    // mine-一次通过，用时3ms，首先将为负数的转换为正数，之后重新排序，再算平方
    public static int[] sortedSquares(int []nums){
        for (int i=0;i<nums.length;i++){
            if (nums[i]<0){
                nums[i]= nums[i]*-1;
            }
        }
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++){
            nums[i] = nums[i]*nums[i];
        }
        return nums;
    }

    // mine-一次通过，先平方后直接排序
    public static int[] sortedSquares02(int []nums){
        for (int i=0;i<nums.length;i++){
            nums[i] = nums[i]*nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    // 双指针法
    public static int[] sortedSquaresBetter(int []nums){
       int n = nums.length;
       int []ans = new int[n];
       for (int i=0,j=n-1,pos=n-1;i<=j;){
            if (nums[i]*nums[i]>nums[j]*nums[j]){
                ans[pos] = nums[i]*nums[i];
                i++;
            }else {
                ans[pos] = nums[j]*nums[j];
                j--;
            }
            pos--;
       }
       return ans;
    }
}
