package DP;

import java.util.HashMap;

public class Solution {
    public static HashMap<Integer, Integer> hashMap = new HashMap<>();

    // 0,1,1,2,3,5
    public static void main(String[] args) {
        System.out.println(fib(48));
    }

    public static int fib(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (hashMap.containsKey(n)) {
            return hashMap.get(n);
        }

        int sum =  fib(n - 1) + fib(n - 2);
        hashMap.put(n, sum);
        return sum;
    }


}
