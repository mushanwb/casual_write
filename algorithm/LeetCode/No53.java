package LeetCode;

import org.omg.PortableInterceptor.SUCCESSFUL;

public class No53 {

//    给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//    示例:
//    输入: [-2,1,-3,4,-1,2,1,-5,4]
//    输出: 6
//    解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    // 方法一:
//    public static int maxSubArray(int[] nums) {
//        // 最大总和，初始值为数组第一个元素
//        int maxSum = nums[0];
//        // 区域总和，初始值为 0
//        int tempSum = 0;
//        if (nums.length == 1) {
//            return maxSum;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            tempSum = tempSum + nums[i];
//
//            // 如果 区域和 < 0,将终止区域累加，并记录最大值
//            //      先将 区域和 归0（归 0 的动作代表前面的值已经计算完）
//            //      如果 当前值 > 最大和，则重新记录 最大和 的值
//            // 如果 区域和 >= 0,进行累加，并记录每次累加后的最大值
//            //      如果 区域和 > 最大和，记录 最大和
//            if (tempSum < 0) {
//                if (nums[i] > maxSum) {
//                    maxSum = nums[i];
//                }
//                tempSum = 0;
//            } else {
//                if (tempSum >= maxSum) {
//                    maxSum = tempSum;
//                }
//            }
//        }
//
//        return maxSum;
//    }

    // 方法二:
    public static int maxSubArray(int[] nums) {
        // 最大总和，初始值为数组第一个元素
        int maxSum = nums[0];
        // 区域总和，初始值为 0
        int tempSum = 0;
        for (int i = 0; i < nums.length; i++) {
//            如果 tempSum > 0，则说明 tempSum 对结果有增益效果，则 tempSum 保留并加上当前遍历数字
//            如果 tempSum <= 0，则说明 tempSum 对结果无增益效果，需要舍弃，则 tempSum 直接更新为当前遍历数字
//            每次比较 tempSum 和 maxSum，将最大值置为 maxSum，遍历结束返回结果
            if (tempSum > 0) {
                tempSum = tempSum + nums[i];
            } else {
                tempSum = nums[i];
            }
            maxSum = Math.max(tempSum,maxSum);
        }

        return maxSum;
    }

}
