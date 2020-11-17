package Recursive;

import java.util.Arrays;
import java.util.List;

public class ListSum {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4);
        System.out.println(sum(list));
    }

    /*
    获取 list 中的元素和
    可以理解为每次拿到第一个元素以及后面所有元素的和
     */
    public static int sum(List<Integer> list) {
        if (list.size() == 0) {
            return 0;
        } else {
            return list.get(0) + sum(list.subList(1, list.size()));
        }
    }
}
