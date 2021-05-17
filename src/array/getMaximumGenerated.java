package array;

import java.util.Arrays;

/**
 * @Description: 获取生成数组中的最大值
 * @Author: wenjianli
 * @Date: 2020/12/29 20:41
 */
/*
给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
    nums[0] = 0
    nums[1] = 1
    当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
    当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
返回生成数组 nums 中的 最大 值。
 */
public class getMaximumGenerated {
    public static void main(String[] args) {
        int n = 32;
        System.out.println(getMaximumGenerated(n));
    }

    // mine-通过，直接构造后进行排序取最大值
    public static  int getMaximumGenerated(int n){
        int []nums = new int[n+1];
        if (n==0){
            return 0;
        }
        nums[0] = 0;
        nums[1] = 1;
        for (int i=1;i<=n;i++){
           if (2*i<=n && 2*i>=2){
               nums[2*i] = nums[i];
           }
           if (2*i+1>=2 && 2*i+1<=n){
               nums[2*i+1] = nums[i]+nums[i+1];
           }
        }
        System.out.println(Arrays.toString(nums));
        Arrays.sort(nums);
        return nums[n];
    }
}
