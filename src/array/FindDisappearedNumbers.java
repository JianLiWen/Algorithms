package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description:找到所有数组中消失的数字
 * @Author: wenjianli
 * @Date: 2021/6/2 18:54
 */
/*
给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
输入：nums = [4,3,2,7,8,2,3,1]
输出：[5,6]
输入：nums = [1,1]
输出：[2]
 */
public class FindDisappearedNumbers {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1};
        List<Integer> list = findDisappearedNumbers(nums);
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    // mine-通过，耗时48ms
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        if (length==0){
            return new ArrayList<>();
        }
        for (int i=1;i<=length;i++){
            map.put(i,0);
        }
        for (int i=0;i<length;i++){
            if (map.get(nums[i])==0){
                map.put(nums[i],1);
            }
            else {
                continue;
            }
        }
        List<Integer> list = map.entrySet().stream().filter(val->val.getValue()==0).map(e->e.getKey()).collect(Collectors.toList());
        return list;
    }
}
