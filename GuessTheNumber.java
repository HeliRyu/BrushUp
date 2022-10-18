import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    /*
     *程序自动生成一个1~100的数字，使用程序猜出这个数字。
     *保底，猜到第三次就能猜中。
     * */
    public static void main(String[] args) {
        //统计当前已经猜的次数。
        int count = 0;
        Random r = new Random();
        //小括号里表示随机数范围。[0,100)
        int randomNumber = r.nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入你要猜的数字");
            int guessNumber = sc.nextInt();
            count++;
            if (count == 3) {
                System.out.println("猜中啦");
                break;
            }
            if (guessNumber < randomNumber) {
                System.out.println("小了");
            } else if (guessNumber > randomNumber) {
                System.out.println("大了");
            } else {
                System.out.println("猜中啦");
                break;
            }
        }
    }
}
