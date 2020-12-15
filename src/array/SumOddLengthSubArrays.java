package array;

/**
 * @Description: 所有奇数长度子数组的和
 * @Author: wenjianli
 * @Date: 2020/12/15 10:49
 */
/*
给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
子数组 定义为原数组中的一个连续子序列。
请你返回 arr 中 所有奇数长度子数组的和 。

输入：arr = [1,4,2,5,3]
输出：58
解释：所有奇数长度子数组和它们的和为：
[1] = 1
[4] = 4
[2] = 2
[5] = 5
[3] = 3
[1,4,2] = 7
[4,2,5] = 11
[2,5,3] = 10
[1,4,2,5,3] = 15
我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58

 */
public class SumOddLengthSubArrays {
    public static void main(String[] args) {
        int []arr = new int[]{1,4,2,5,3};
        System.out.println(sumOddLengthSubarrays(arr));
    }

    // 反其道而行之，去统计每个数字在奇数长度子数组中出现的次数
    public static int sumOddLengthSubarrays(int[] arr) {
        int res = 0;
        for(int i = 0; i < arr.length; i ++){
            int left = i + 1, right = arr.length - i,
                    left_even = (left + 1) / 2, right_even = (right + 1) / 2,
                    left_odd = left / 2, right_odd = right / 2;
            res += (left_even * right_even + left_odd * right_odd) * arr[i];
        }
        return res;
    }
}
