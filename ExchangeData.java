public class ExchangeData {
    /*
     * 定义一个数组，交换首尾索引对应的元素。
     * */
    public static void main(String[] args) {
        int[] arr = {6, 5, 7, 9, 77};
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
