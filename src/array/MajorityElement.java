package array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 主要元素
 * @Author: wenjianli
 * @Date: 2020/12/14 11:26
 */
/*
数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
输入：[1,2,5,9,5,9,5,5,5]
输出：5

输入：[3,2]
输出：-1

输入：[2,2,1,1,1,2,2]
输出：2
 */
public class MajorityElement {
    public static void main(String[] args) {
        int [] nums = new int[]{3,2};
        System.out.println(majorityElement(nums));
    }

    // mine-一次通过，但用时比较长20ms 思路：用一个map来存储数字和数字出现的次数，最后遍历map的key，找到value大于数据长度一般的值
    public static  int majorityElement(int []num){
        int n = num.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<n;i++){
            if (map.containsKey(num[i])){
                map.put(num[i],map.get(num[i])+1);
            }else {
                map.put(num[i],1);
            }
        }
        System.out.println(map);
        for (Integer key:map.keySet()){
            if (map.get(key) > n/2){
                return key;
            }
        }
        return -1;
    }
}

