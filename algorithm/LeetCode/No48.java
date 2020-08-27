package LeetCode;

import java.util.Arrays;

public class No48 {

//    给定一个 n × n 的二维矩阵表示一个图像。
//
//    将图像顺时针旋转 90 度。
//
//    说明：
//
//    你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
//
//    示例 1:
//
//    给定 matrix =
//    [
//        [1,2,3],
//        [4,5,6],
//        [7,8,9]
//    ],
//
//    原地旋转输入矩阵，使其变为:
//    [
//            [7,4,1],
//            [8,5,2],
//            [9,6,3]
//    ]
//    示例 2:
//
//    给定 matrix =
//    [
//        [ 5, 1, 9,11],
//        [ 2, 4, 8,10],
//        [13, 3, 6, 7],
//        [15,14,12,16]
//    ],
//
//    原地旋转输入矩阵，使其变为:
//    [
//            [15,13, 2, 5],
//            [14, 3, 4, 1],
//            [12, 6, 8, 9],
//            [16, 7,10,11]
//    ]

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
//        int[][] matrix = {
//                {5, 1, 9,11},
//                {2, 4, 8,10},
//                {13, 3, 6, 7},
//                {15,14,12,16}
//        };
        rotate(matrix);
        for (int[] matrixArray:matrix) {
            System.out.println(Arrays.toString(matrixArray));
        }
    }

    // 借着调试器认真的计算每个位置的是如何通过 i，j 的变换得到的即可。
    // 先从外圈旋转，再到内圈，直到最后
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int j = 0;
        while (j < n / 2) {
            for (int i = 0; i < (n - 1 - 2*j); i++) {
                int temp = matrix[j][j+i];
                matrix[j][j+i] = matrix[n-1-i-j][j];
                matrix[n-1-i-j][j] = matrix[n-1-j][n-1-i-j];
                matrix[n-1-j][n-1-i-j] = matrix[i+j][n-1-j];
                matrix[i+j][n-1-j] = temp;
            }
            j++;
        }
    }




}
