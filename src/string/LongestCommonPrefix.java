package string;

/**
 * @Description:最长公共前缀
 * @Author: wenjianli
 * @Date: 2021/5/28 11:45
 */
/*
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

输入：strs = ["flower","flow","flight"]
输出："fl"

输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{"a","ac"};
        System.out.println(longestCommonPrefix(strs));
    }

    // mine--特殊情况没通过 “aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa”
    public static String longestCommonPrefix(String[] strs) {
        String str = strs[0];
        StringBuffer stringBuffer = new StringBuffer();
        if(strs.length==1){
            return strs[0];
        }
        if(str.equals("")) {
            return "";
        }
        int sub= 0;
        int minLength = 0;
        for (int i=1;i<strs.length;i++){
            String s = strs[i];
            if(s.equals("")){
                return "";
            }
            if (s.charAt(0)!=str.charAt(0)){
                return "";
            }
            if (i==1){
                int minlength = Math.min(s.length(),str.length());
                for (int b=0;b<minlength;b++){
                    if (s.charAt(b)==str.charAt(b)){
                        sub++;
                        stringBuffer.append(str.charAt(b));
                    } else {
                        break;
                    }
                }
            }else {
                minLength = Math.min(s.length(),stringBuffer.length());
                int m = 0;
                for (int c=0;c<minLength;c++){
                    if(s.charAt(c)==stringBuffer.charAt(c)){
                        m++;
                        continue;
                    }else {
                        break;
                    }
                }
                sub=m;
            }
        }
        System.out.println(sub);
        return stringBuffer.substring(0,sub);
    }

    public static String isbetter(String[] strs){
        if(strs.length == 0)
            return "";
        String ans = strs[0];
        for(int i =1;i<strs.length;i++) {
            int j=0;
            for(;j<ans.length() && j < strs[i].length();j++) {
                if(ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if(ans.equals(""))
                return ans;
        }
        return ans;
    }
}
