import java.util.Scanner;

public class PalindromeTest {
    /*
     * 输入一个整数x，如果是回文打印true，反之为false。
     * 思路：把数字倒过来和原数字比较。
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int temp = x;
        //把输入数倒过来的结果
        int xPalindrome = 0;
        while (temp != 0) {
            int singleDigit = temp % 10;
            //删去最右边的数
            temp = temp / 10;
            //把获取到的数字放到最终数的最右
            xPalindrome = xPalindrome * 10 + singleDigit;
        }
        System.out.println(x == xPalindrome);
    }
}
