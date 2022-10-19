import java.util.Random;

public class AuthCode {
    /*
     * 实现随机生成一个5位的验证码。
     * 前4位是大写字母或小写字母，最后1位是数字。
     * */
    public static void main(String[] args) {
        //思路：需要抽取随机数据的情况，可以放在数组中再随机索引
        //1）利用ASCII表将大小写字母放入数组
        char[] chs = new char[52];
        for (int i = 0; i < chs.length; i++) {
            if (i <= 25) {
                //数组索引从0开始，放入小写字母；ASCII的a对应97。
                chs[i] = (char) (97 + i);
            } else {
                //数组索引从26开始，放入大写字母；ASCII的A对应65。
                chs[i] = (char) (65 + i - 26);
            }
        }
        //2)随机生成索引4次，把索引对应的大小写字母放入字符串中
        String StringCode = "";
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            int randomIndex = r.nextInt(chs.length);
            StringCode = StringCode + chs[randomIndex];
        }
        //3)随机生成数字0~9放入字符串尾（可扩展放入字符串的不同位置）
        int number = r.nextInt(10);
        StringCode = StringCode + number;
        System.out.println("随机验证码是" + StringCode);
    }
}
