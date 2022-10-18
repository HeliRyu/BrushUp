import java.util.Random;

public class ArraySumTest {
    /*
     * 生成一个数组，含有10个1~100之间的随机数。
     * 求所有数据的和与平均数。
     * 统计有多少个数据比平均数小。
     * */
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            int number = r.nextInt(100) + 1;
            arr[i] = number;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        System.out.println("所有数据的和为" + sum);
        System.out.println("所有数据的平均数为" + (sum / arr.length));
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < (sum / arr.length)) {
                count++;
            }
        }
        System.out.println("有" + count + "个数据比平均数小");
    }
}
