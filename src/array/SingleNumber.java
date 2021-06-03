package array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description:只出现一次的数字
 * @Author: wenjianli
 * @Date: 2021/6/3 10:25
 */
/*
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
输入: [2,2,1]
输出: 1

输入: [4,1,2,1,2]
输出: 4
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }

    // mine-通过 耗时20ms，还需优化
    public static int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        if (nums.length ==1){
            return nums[0];
        }
        for (int i=0;i<nums.length;i++){
            if (!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else {
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
       List<Integer> list = map.entrySet().stream().filter(e->e.getValue()==1).map(e->e.getKey()).collect(Collectors.toList());
        return list.get(0);
    }
}
