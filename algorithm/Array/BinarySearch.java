package Array;

public class BinarySearch {

    // 搜索一个有序的数组，二分查找指定元素,返回指定元素的索引值
    public static void main(String[] args) {
        int[] array = {1,4,5,9,10,15,16,19};
        int target = 8;
        System.out.println(binarySearch(array, 0, 7, target));
    }

    // 非递归
//    public static int binarySearch(int[] array, int target) {
//        int start = 0, end = array.length - 1;
//
//        while (true) {
//            if (array[start] == target) {
//                return start;
//            }
//            if (array[end] == target) {
//                return end;
//            }
//
//            if (array[start] > target || array[end] < target) {
//                return -1;
//            }
//
//            int mid = (end + start) / 2;
//            if (array[mid] > target) {
//                end = mid - 1;
//            } else if (array[mid] < target) {
//                start = mid + 1;
//            } else {
//                return mid;
//            }
//        }
//    }


    // 递归
    public static int binarySearch(int[] array, int start, int end, int target) {
        int mid = (start + end) / 2;
        if (array[mid] == target) {
            return mid;
        }

        if (start > end) {
            return -1;
        }
        if (array[mid] > target) {
            end = mid - 1;
        } else if (array[mid] < target) {
            start = mid + 1;
        } else {
            return mid;
        }
        return binarySearch(array, start, end, target);
    }

}
