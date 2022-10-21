public class ArrayCopy {
    /*
     * 把一个既定数组的元素复制到另一个新数组中去。
     * */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] arrNew = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrNew[i] = arr[i];
        }
        for (int i = 0; i < arrNew.length; i++) {
            System.out.print(arrNew[i] + ",");
        }
    }
}

