import java.util.Random;

public class LotteryArrayMethod {
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
    public static void main(String[] args) {
        //第一种实现方式：新建一个数组，放置随机抽取后对比不重复的奖金数据。
        //1）定义数组表示奖池
        int[] lotteryArr = {2, 588, 888, 1000, 10000};
        //2)定义新数组用于存储抽奖的结果
        int[] lotteryResult = new int[lotteryArr.length];
        //3)抽奖
        Random r = new Random();
        //从奖池里抽5个奖
        for (int i = 0; i < 5; ) {
            int randomIndex = r.nextInt(lotteryArr.length);
            //根据随机索引随机抽取奖池里的奖金
            int outcome = lotteryArr[randomIndex];
            boolean flag = outcomeInLotteryResult(lotteryResult, outcome);
            //如果没有抽中过，把当前奖项添加到已抽取的结果数组中
            if (!flag) {
                lotteryResult[i] = outcome;
                //★★★★★只有添加至结果数组中，才移动索引
                i++;
            }
        }
        //4)遍历打印出抽奖结果
        for (int i = 0; i < lotteryResult.length; i++) {
            System.out.println(lotteryResult[i] + "元的奖金被抽出");
        }
    }

    //判断抽出结果outcome在抽奖结果数组lotteryResult里是否存在，存在则为true。
    public static boolean outcomeInLotteryResult(int[] lotteryResult, int outcome) {
        for (int i = 0; i < lotteryResult.length; i++) {
            if (lotteryResult[i] == outcome) {
                return true;
            }
        }
        return false;
    }
}
