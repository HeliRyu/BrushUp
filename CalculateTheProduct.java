public class CalculateTheProduct {
    public static void main(String[] args) {
        //1.将num1和num2变成对应的整数
        String num1 = "12345";
        String num2 = "12";
        int numA = charIntoNum(num1);
        int numB = charIntoNum(num2);
        //2.利用整数进行相乘
        int product = numA * numB;
        //3.将乘积整数变成字符串
        //+""
        String s = product + "";
        System.out.println(s);//148140
    }

    public static int charIntoNum(String str) {
        int num = 0;
        //遍历字符串依次得到每一个字符
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            //将字符变成对应的数字
            int numChar = c - '0';
            //把每一个数字组合到一起
            num = num * 10 + numChar;
        }
        return num;
    }
}
