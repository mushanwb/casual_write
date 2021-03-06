package LeetCode;

import java.util.Arrays;

public class No88 {

//    给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
//
//    说明:
//
//    初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
//    你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
//             
//    示例:
//
//    输入:
//    nums1 = [1,2,3,0,0,0], m = 3
//    nums2 = [2,5,6],       n = 3
//
//    输出: [1,2,2,3,5,6]

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {4,5,6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    // 因为两个数组都是排序好，因此只需要将每个数组的最大元素依次做比较，然后放入 nums1 数组的最大处
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        while (i < n) {
                if ((m-1-j) < 0 || nums1[m-1-j] < nums2[n-1-i]) {
                    nums1[m+n-1-j-i] = nums2[n-1-i];
                    i++;
                } else {
                    nums1[m+n-1-j-i] = nums1[m-1-j];
                    j++;
                }
        }
    }
}
