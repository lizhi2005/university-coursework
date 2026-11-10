package Algorithm;

public class QuietSort {

    static void main() {
        int[] arr = {56, 23, 9, 78, 45, 12, 89, 34, 67, 10};
        quickSort(arr, 0, arr.length - 1); // 调用快排

        // 输出
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }


    }
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        // 分区：把小的放左边，大的放右边
        int pivot = partition(arr, left, right);

        // 递归左边
        quickSort(arr, left, pivot - 1);
        // 递归右边
        quickSort(arr, pivot + 1, right);}

    public static int partition(int[] arr, int left, int right) {
        int base = arr[left]; // 基准数
        int i = left;
        int j = right;

        while (i < j) {
            // 右边找比基准小的
            while (i < j && arr[j] >= base) {
                j--;
            }
            // 左边找比基准大的
            while (i < j && arr[i] <= base) {
                i++;
            }
            // 交换
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        // 基准数归位
        arr[left] = arr[i];
        arr[i] = base;

        return i; // 返回基准位置
    }
}






