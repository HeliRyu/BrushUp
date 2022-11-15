import java.util.Scanner;

public class StringAmountConversion {
    public static void main(String[] args) {
        //1.键盘录入一个金额
        Scanner sc = new Scanner(System.in);
        int money;
        while (true) {
            System.out.println("请录入一个金额");
            money = sc.nextInt();
            if (money >= 0 && money <= 9999999) {
                break;
            } else {
                System.out.println("金额无效");
            }
        }

        //2.得到money里面的每一位数字，并转换成大写中文数字
        //定义一个变量用来表示钱的大写中文数字
        String moneyStr = "";
        while (true) {
            //从右往左获取数据，因为右侧是数据的个位
            int singleDigit = money % 10;
            String capitalNumber = getCapitalNumber(singleDigit);
            //★★★把转换之后的大写中文数字拼接到moneyStr中,注意顺序
            moneyStr = capitalNumber + moneyStr;
            //去掉刚刚获取的个位数
            money = money / 10;
            //如果money为0，即数字上每一位都成为过个位数被获取到了，循环结束
            if (money == 0) {
                break;
            }
        }

        //3.在大写中文数字前补零，至满七位数
        int count = 7 - moneyStr.length();
        for (int i = 0; i < count; i++) {
            moneyStr = "零" + moneyStr;
        }

        //4.★★★插入数字的单位
        //定义一个数组表示单位
        String[] arr = {"佰", "拾", "万", "仟", "佰", "拾", "元"};
        String result = "";
        for (int i = 0; i < moneyStr.length(); i++) {
            char c = moneyStr.charAt(i);
            //★★★循环遍历大写中文数字字符串和单位数组，并拼接
            result = result + c + arr[i];
        }

        //5.打印最终结果
        System.out.println(result);
    }

    //定义一个方法把数字变成大写的中文，1-->壹
    public static String getCapitalNumber(int number) {
        //定义数组，数字与大写的中文数字一一对应
        String[] arr = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        //返回结果
        return arr[number];
    }
}
