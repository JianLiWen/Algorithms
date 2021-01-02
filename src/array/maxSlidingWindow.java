package array;

import com.sun.xml.internal.bind.v2.model.core.EnumLeafInfo;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 滑动窗口最大值
 * @Author: wenjianli
 * @Date: 2021/1/2 22:28
 */
/*
给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
返回滑动窗口中的最大值。
输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
输出：[3,3,5,5,6,7]
解释：
滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

输入：nums = [1], k = 1
输出：[1]
 */
public class maxSlidingWindow {
    public static void main(String[] args) {
        int [] nums = new int[]{4,-2};
        int k = 2  ;
        System.out.println(Arrays.toString(maxSlidingWindow(nums,k)));
    }

    public static  int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> maxNum = new ArrayList<>();
        for (int i=0;i<=nums.length-k;i++){
            int [] b = new int[k];
            for(int j= 0;j<k;j++) {
                b[j] = nums[i + j];
            }
            Arrays.sort(b);
            maxNum.add(b[k-1]);
        }
        return maxNum.stream().mapToInt(Integer::valueOf).toArray();
    }

    // 双向队列
    public int[] maxSlidingWindowBest(int[] nums, int k) {
        if(nums == null || nums.length < 2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length-k+1];
        // 遍历nums数组
        for(int i = 0;i < nums.length;i++){
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if(queue.peek() <= i-k){
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if(i+1 >= k){
                result[i+1-k] = nums[queue.peek()];
            }
        }
        return result;

    }
}
