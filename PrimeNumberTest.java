import java.util.Scanner;

public class PrimeNumberTest {
    /*
     * 输入一个正整数x，判断其是否为质数。
     * 质数是指在大于1的自然数中，除了1和它本身以外不再有其他因数的自然数。
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个正整数x");
        int x = sc.nextInt();
        //默认为质数
        boolean flag = true;
        //假设a*b=x，a<=x的平方根，b>=x的平方根
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                flag = false;
                break;
            }
        }
        /*
        if() 语句,只有()中的boolean为true时,才能执行if()语句下面的{},如果为false时,执行else下面{};
        if(flag)  等于 if(flag == true)
        if(!flag) 等于 if(!flag == true)
         */
        if (flag) {
            System.out.println(x + "是质数");
        } else {
            System.out.println(x + "不是质数");
        }
    }

}
