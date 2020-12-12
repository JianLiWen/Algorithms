package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 两数之和
 * @Author: wenjianli
 * @Date: 2020/12/10 9:48
 */

/*
题目描述给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

*/
public class TwoDataSum {
    public static void main(String[] args) {
        int []nums = new int[]{3,2,4};
        int target = 6;
        int [] index = twoSum_better(nums, target);
        System.out.println("下标索引值为：" + Arrays.toString(index));
    }

    // 自己写，用时8毫秒，内存38.6M 暴力法，遍历数组，分别找到两个和为target的索引，但是这样复杂度太高
    public static int[] twoSum(int[] nums,int target){
        int [] arrayIndex = new int[2];
        for (int i=0;i<=nums.length-2;i++){
            for (int j=i+1;j<=nums.length-1;j++) {
                if (nums[i] + nums[j] == target) {
                    arrayIndex[0] = i;
                    arrayIndex[1] = j;
                }
            }
        }
        return arrayIndex;
    }

    // 哈希表，对于每一个 x，我们首先查询哈希表中是否存在 target - x，然后将 x 插入到哈希表中，即可保证不会让 x 和自己匹配。
    public static int[] twoSum_better(int[] nums,int target){
        Map<Integer,Integer> hashTable = new HashMap<>();
        for (int i=0;i<nums.length;++i){
            if(hashTable.containsKey(target-nums[i])){
                return new int[]{hashTable.get(target-nums[i]),i};
            }
            hashTable.put(nums[i],i);
        }
        return new int[0];
    }
    //复杂度分析
    //
    //    时间复杂度：O(N)，其中N是数组中的元素数量。对于每一个元素 x，我们可以 O(1) 地寻找 target - x。
    //
    //    空间复杂度：O(N)，其中N是数组中的元素数量。主要为哈希表的开销。
    //

}
