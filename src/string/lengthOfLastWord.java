package string;


/**
 * @Description:最后一个单词的长度
 * @Author: wenjianli
 * @Date: 2021/1/11 20:45
 */
/*
给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。

如果不存在最后一个单词，请返回 0 。

说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
输入: "Hello World"
输出: 5

输入: "Hello World "
输出: 5
 */
public class lengthOfLastWord {
    public static void main(String[] args) {
        String s = "a ";
        System.out.println(s.length());
        System.out.println(lengthOfLastWord(s));
    }

    // 分别找到对应的start和end的位置，先从后过滤掉空格找到单词尾部，再从尾部向前遍历，找到单词头部，最后两者相减，即为单词的长度
    public static int lengthOfLastWord(String s) {
        int end = s.length()-1;
        while (end>=0&&s.charAt(end)==' '){
            end--;
        }
        if (end<0)
            return 0;
        int start = end;
        while (start>=0&&s.charAt(start)!=' '){
            start--;
        }
        return end-start;
    }

    // 我的思路是从后往前进行计数，遇到不是空格的就加1，关键就是去掉尾部的空格
}
