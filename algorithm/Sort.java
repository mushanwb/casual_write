
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort {
    public static void main(String[] args) {
        int[] a = new int[]{1,5,4,8,6,7,2,9,3};
//        Bubble(a);
//        Insert(a);
        quickSort(a,0, a.length-1);
        System.out.println(Arrays.toString(a));
    }

    //冒泡排序（ O(n²) ）(重点)
    public static void Bubble(int[] a) {
        for (int i=0;i<a.length;i++) {
            boolean flag = false;
            for (int j=0;j<a.length-i-1;j++) {
                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

    //插入排序（ O(n²) ）
    public static void Insert(int[] a) {
        for (int i=1; i < a.length; i++) {
            int value = a[i];
            int j;
            for (j = i-1; j >=0 ;j--) {
                if (a[j] > value) {
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }
            a[j+1] = value;
        }
    }

    //归并排序（ O(nlogn) ）
    public static void Merge(int[] a) {

    }

    //快速排序（ O(nlogn) ）(重点)
    public static void quickSort(int[] a, int low, int hight) {
        int i = low;
        int j = hight;
        if (low > hight) {
            return;
        }
        int temp = a[j];
        while (i < j) {
            while (i < j && a[i] < temp) {
                i++;
            }
            if (i < j) {
                a[j] = a[i];
                a[i] = temp;
            }
            while (i < j && a[j] >= temp) {
                j--;
            }
            if (i < j) {
                a[i] = a[j];
                a[j] = temp;
            }
        }
//        a[i] = temp;
        quickSort(a,low,i-1);
        quickSort(a,i+1,hight);

    }

}

