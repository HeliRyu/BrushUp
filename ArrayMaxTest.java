public class ArrayMaxTest {
    /*
     * 定义一个数组，求最大值。
     * */
    public static void main(String[] args) {
        int[] arr = {78, 89, 33, 599, 64, 3};
        //max的初始化一定要是数组里的值。
        int max = arr[0];
        //从1开始，减少与自己比的次数
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("最大值为" + max);
    }
}
