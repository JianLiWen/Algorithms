package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:数组序号转换
 * @Author: wenjianli
 * @Date: 2020/12/19 22:54
 */
/*
给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。

序号代表了一个元素有多大。序号编号的规则如下：

    序号从 1 开始编号。
    一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
    每个数字的序号都应该尽可能地小。
输入：arr = [40,10,20,30]
输出：[4,1,2,3]
解释：40 是最大的元素。 10 是最小的元素。 20 是第二小的数字。 30 是第三小的数字。

 */
public class ArrayRankTransform {
    public static void main(String[] args) {
        int []arr = new int[]{100,100,100};
        System.out.println(Arrays.toString(arrayRankTransform(arr)));
    }
    public static  int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int [] rank = new int[n];
        int [] nums = arr.clone();
        Arrays.sort(arr);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0,j=1;i<n;i++){
            if (!map.containsKey(arr[i])){
                map.put(arr[i],j);
                j++;
            }
        }
        for(int i=0;i<n;i++){
            rank[i] = map.get(nums[i]);
        }
        return rank;
    }
}
