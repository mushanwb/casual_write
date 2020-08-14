package LeetCode;

import java.util.*;

public class No15 {

//    给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
//    使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

//    注意：答案中不可以包含重复的三元组。

//    给定数组 nums = [-1, 0, 1, 2, -1, -4]，
    // -4,-1,-1,0,1,2
//
//    满足要求的三元组集合为：
//            [
//                [-1, 0, 1],
//                [-1, -1, 2]
//            ]


    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {-2,0,1,1,2};
        System.out.println(threeSum(nums).toString());
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        if (nums.length < 3) {
            return lists;
        }
        Arrays.sort(nums);
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {      // 如果结果小于0，左边指针往右移动
                    left++;
                } else if (sum > 0) {       //如果结果大于0，右边往左指针移动
                    right--;
                } else {
                    // 等于0时，两个指针都往中间移动，寻找下一个组合
                    lists.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                    // 如果左边指针移动后的数跟前一个数相等，说明数据重复，继续移动
                    while (left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                    // 如果右边指针移动后的数跟前一个数相等，说明数据重复，继续移动
                    while (left < right && nums[right] == nums[right+1]) {
                        right--;
                    }

                }

            }
        }
        return lists;
    }

}
