import java.util.Scanner;

public class Quotient {
    /*
     * 求商和余数。
     * 输入两个不超过int范围的正整数作为被除数和除数。
     * 要求不使用乘法、除法或%运算符。
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入被除数");
        int dividend = sc.nextInt();
        System.out.println("请输入除数");
        int divisor = sc.nextInt();
        //统计使用减法次数
        int count = 0;
        while (dividend >= divisor) {
            dividend = dividend - divisor;
            count++;
        }
        System.out.println("商为" + count);
        System.out.println("余数为" + dividend);
    }
}
