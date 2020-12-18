package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:最大连续1的个数
 * @Author: wenjianli
 * @Date: 2020/12/18 23:12
 */
/*
给定一个二进制数组， 计算其中最大连续1的个数。
输入: [1,1,0,1,1,1]
输出: 3
解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int []nums = new int[]{1,0,1,1,0,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    // mine-通过 反其道而行之，去根据0作为分割线去判断1的个数
    public static int findMaxConsecutiveOnes(int []nums){
        int n = nums.length;
        int max = 0;
        if(n==1&& nums[0]==1){
            return 1;
        }
        if(n==1 && nums[0]==0){
            return 0;
        }
        Map<Integer,Integer> numsMap = new HashMap<>();
        for(int i=0;i<n;i++){
            if(nums[i]==0 && !numsMap.containsKey(0)){
                max = i;
                numsMap.put(0,i);
            }else if(nums[i]==0 && numsMap.containsKey(0)){
                max = Math.max(i-numsMap.get(0)-1,max);
                numsMap.replace(0,numsMap.get(0),i);
            }
        }
        if(!numsMap.containsKey(0)){
            return n;
        }
        max = Math.max(max,n-numsMap.get(0)-1);
        return max;
    }
}
