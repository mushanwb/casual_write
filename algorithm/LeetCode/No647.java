package LeetCode;

public class No647 {

//    给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
//
//    具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
//
//    “回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。
//
//
//    示例 1：
//
//    输入："abc"
//    输出：3
//    解释：三个回文子串: "a", "b", "c"
//    示例 2：
//
//    输入："aaa"
//    输出：6
//    解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"

    public static void main(String[] args) {
        String s = "aba";
        System.out.println(countSubstrings(s));
    }

//    方法一：三层循环，枚举
//    public static int countSubstrings(String s) {
//        char[] sToChar = s.toCharArray();
//        int count = sToChar.length;
//        for (int i = 0; i < sToChar.length; i++) {
//            int right = sToChar.length - 1;
//            while (right > i) {
//                int j = 0;
//                int left = i;
//                while (sToChar[left] == sToChar[right - j]) {
//                    if (left == (right- j) || (left+1) == (right - j)) {
//                        count = count + 1;
//                        break;
//                    }
//                    j++;
//                    left++;
//                }
//                right--;
//            }
//
//        }
//        return count;
//    }


//    方法二：
//    把字符串中的 一个或者相邻两个字符 当作中心，
//    然后通过两个指针 分别向左向右 扩展，并在扩展的过程中记录当前时刻是否具有 回文属性
//    （注意：必须把 当前元素为中心元素 和 当前元素与后一个元素同为中心元素 两种情况都考虑到）

    public static int countSubstrings(String s) {

        char[] sToChar = s.toCharArray();
        int count = 0;
        for (int i = 0; i < sToChar.length; i++) {
            count = count + countPalindrome(sToChar, i, i);
            count = count + countPalindrome(sToChar, i, i+1);
        }

        return count;
    }

    private static int  countPalindrome(char[] chars, int start, int end) {
        int curRes = 0;
        int length = chars.length;
        while ((start >= 0) && (end < length) && (chars[start]) == chars[end]) {
            curRes++;
            start--;
            end++;
        }
        return curRes;
    }

}
