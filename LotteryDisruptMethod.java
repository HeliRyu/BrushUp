import java.util.Random;

public class LotteryDisruptMethod {
    /*
     * 抽奖，分别有{2,588,888,1000,10000}五个奖金。
     * 请使用代码模拟抽奖，打印出每个奖项。奖项的出现顺序要随机且不重复。
     * 打印效果如下：可随机顺序。
     * 888元的奖金被抽出。
     * 588元的奖金被抽出。
     * 10000元的奖金被抽出。
     * 1000元的奖金被抽出。
     * 2元的奖金被抽出。
     * */
    //第二种方式：打乱顺序。
    public static void main(String[] args) {
        //1)打乱奖池数组里的所有数据
        int[] arr = {2, 588, 888, 1000, 10000};
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            //获取随机索引
            int randomIndex = r.nextInt(arr.length);
            //让遍历的值与随机索引的值交换
            int temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }
        //2)遍历奖池
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "元的奖金被抽出。");
        }
    }

}
