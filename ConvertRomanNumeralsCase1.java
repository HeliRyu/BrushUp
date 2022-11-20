import java.util.Scanner;

public class ConvertRomanNumeralsCase1 {
    public static void main(String[] args) {
        //1.键盘录入一个字符串
        //书写Scanner代码
        Scanner sc = new Scanner(System.in);
        //校验和转换都需要用到str
        String str;
        while (true) {
            System.out.println("请输入一个字符串");
            str = sc.next();//123456789
            //2.校验字符串是否满足规则
            boolean flag = checkStr(str);
            if (flag) {
                break;
            } else {
                System.out.println("当前的字符串不符合规则，请重新输入");
                continue;
            }
        }
        //3.将内容变成罗马数字Ⅰ-1、Ⅱ-2、Ⅲ-3、Ⅳ-4、Ⅴ-5、Ⅵ-6、Ⅶ-7、Ⅷ-8、Ⅸ-9
        //查表法：数字跟数据产生一个对应关系
        //不需要间隔符号的字符串拼接使用StringBuilder
        //★★★★★转换顺序：String数字字符串--》char数字字符--》int数字--》String字符串--》StringBuilder字符串拼接
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            //★★★ASCII表
            int number = c - 48;
            String s = changeIntoRoman(number);
            sb.append(s);
        }
        System.out.println(sb);//ⅠⅡⅢⅣⅤⅥⅦⅧⅨ
    }

    //转换成罗马数字
    public static String changeIntoRoman(int number) {
        //定义一个数组，让索引和罗马数字产生一个对应关系
        //★★★罗马数字没有0。如果键盘录入的数字包含0，可以变成“”（ 长度为0的字符串。）
        String[] arr = {"", "Ⅰ", "Ⅱ", "Ⅲ", "Ⅳ", "Ⅴ", "Ⅵ", "Ⅶ", "Ⅷ", "Ⅸ" };
        return arr[number];
    }

    //校验字符串是否满足规则
    public static boolean checkStr(String str) {
        //1)要求1：长度为小于等于9
        if (str.length() > 9) {
            return false;
        }
        //2)要求2：只能是数字
        //★★★ASCII表
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);//0~9
            if (c < '0' || c > '9') {
                return false;
            }
        }
        //当字符串里面所有字符判断都是数字字符后，才能确认其符合规则
        return true;
    }
}
