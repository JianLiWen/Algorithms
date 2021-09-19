package string.hard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Description:最小覆盖子串
 * @Author: wenjianli
 * @Date: 2021/9/19 19:40
 */
public class minWindow {



    public static void main(String[] args) {
        String a = "ANKSORPMSDS";
        String b = "SRP";
        System.out.println(stringMinWindow(a,b));
    }
        public static String stringMinWindow(String s, String t){
            Map<Character,Integer> ori = new HashMap<>();
            Map<Character,Integer> cnt =new HashMap<>();
            int tLen = t.length();
            // 初始化
            for(int i=0;i<tLen;i++){
                char c = t.charAt(i);
                ori.put(c,ori.getOrDefault(c,0)+1);
            }
            int l=0,r=-1;
            int len = Integer.MAX_VALUE,ansL=-1,ansR=-1;
            int sLen = s.length();
            while (r<sLen){
                ++r;
                // 如果当前窗口包含所需字符，那么就记录字符的个数
                if (r<sLen&&ori.containsKey(s.charAt(r))){
                    cnt.put(s.charAt(r),cnt.getOrDefault(s.charAt(r),0)+1);
                }
                while (check(ori,cnt) && l<=r){
                    if (r-l+1 <len){
                        len = r-l+1;
                        ansL = l;
                        ansR = l + len;
                    }
                    if (ori.containsKey(s.charAt(l))){
                        cnt.put(s.charAt(l),cnt.getOrDefault(s.charAt(l),0)-1);
                    }
                    ++l;
                }
            }
            return ansL == -1?"":s.substring(ansL,ansR);
        }
        public static boolean check(Map<Character, Integer> ori, Map<Character, Integer> cnt){
            Iterator iter = ori.entrySet().iterator();
            while (iter.hasNext()){
                Map.Entry entry = (Map.Entry)iter.next();
                Character key = (Character) entry.getKey();
                Integer value = (Integer) entry.getValue();
                if (cnt.getOrDefault(key,0)<value) {
                    return false;
                }
            }
            return true;
        }
}
