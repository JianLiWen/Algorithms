package array;

import java.util.Arrays;

/**
 * @Description: 在排序数组中查找元素的第一个位置和最后一个位置
 * @Author: wenjianli
 * @Date: 2020/12/11 9:47
 */

/*
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

如果数组中不存在目标值 target，返回 [-1, -1]。
示例：
输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]

输入：nums = [1]  1
输出：[0,0]

输入：nums =[1] 0
输出：[-1,-1]

输入: nums[2,2] 2
输出：[0,1]
 */
public class SearchDataRange {
    public static void main(String[] args) {
        int []nums = {5,7,7,8,8,10};
        int target = 8;
        int[] index =  searchDataRangeBetter(nums, target);
        System.out.println(Arrays.toString(index));
    }

    // mine-01
    // 需要考虑特殊情况，只有一个数字的数组
    public static int[] searchRange(int []nums, int target){
        int firstIndex = 0;
        int endIndex = 0;
        boolean flag = false;
        if (nums.length==1 && nums[0]==target){
            return new int[]{0,0};
        }
        if (nums.length == 1 && nums[0]!=target){
            return new int[]{-1,-1};
        }
        for (int i=0;i<nums.length;i++){
            if (nums[i]==target && flag==false){
                firstIndex = i;
                flag = true;
            }
            if (nums[i]>target && flag==true){
                endIndex = i-1;
                break;
            }
            if( i==nums.length-1 && nums[i]==target && flag==true){
                endIndex = i;
                break;
            }
        }
        if (flag==false){
            return new int[]{-1,-1};
        }
        return  new int[]{firstIndex,endIndex};
    }

    // 优化解方法：通过二分查找算法
    // 二分查找法相当于寻找第一个大于等于target的left标以及第一个大于target的right标
    public static int[] searchDataRangeBetter(int nums[],int target){
        int lowIndex = binarySearch(nums,target,true);
        int highIndex = binarySearch(nums,target,false) -1;
        if (lowIndex<=highIndex && highIndex<nums.length && nums[lowIndex]==target && nums[highIndex] == target){
            return new int[]{lowIndex,highIndex};
        }
        return new int[]{-1,-1};
    }

    private static  int binarySearch(int nums[],int target,boolean lower){
        int low = 0;
        int high = nums.length-1;
        int ans = nums.length;
        while (low<=high){
            int mid = (low+high)/2;
            if (nums[mid] > target || lower && nums[mid]>=target){
                high--;
                ans = mid;
            }else{
                low++;
            }
        }
        return ans ;
    }
}
