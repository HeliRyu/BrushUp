import java.util.Scanner;

public class SquarerootTest {
    /*
     *输入一个大于等于2的整数x，计算并返回x的平方根的整数部分。
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个大于等于2的整数");
        int x = sc.nextInt();
        for (int i = 1; i <= x; i++) {
            if (i * i == x) {
                System.out.println("整数" + x + "的平方根为" + i);
                break;
            } else if (i * i > x) {
                System.out.println("整数" + x + "的平方根整数部分为" + (i - 1));
                break;
            }
        }
    }
}
