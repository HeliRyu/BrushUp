import java.util.Random;

public class Captchas {
    public static void main(String[] args) {
        //1.将所有大写字母、小写字母都放到一个数组当中
        char[] arr = new char[52];
        for (int i = 0; i < arr.length; i++) {
            if (i <= 25) {
                arr[i] = (char) (97 + i);
            } else {
                arr[i] = (char) (65 + i - 26);
            }
        }
        //2.从数组中随机获取4次
        String code = "";
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            int randomIndex = r.nextInt(arr.length);
            code = code + arr[randomIndex];
        }
        //3.生成一个0~9之间的随机数拼接到最后
        code = code + r.nextInt(10);
        System.out.println(code);//RjSS7
        //4.改变数字的位置，即修改字符串
        //将生成的字符串变成一个字符数组，再让最后一个元素与前面的随机位置进行交换
        char[] charArray = code.toCharArray();
        int randomChar = r.nextInt(charArray.length);
        char temp = charArray[randomChar];
        charArray[randomChar] = charArray[charArray.length - 1];
        charArray[charArray.length - 1] = temp;
        //交换后再变成字符串
        String s = new String(charArray);
        System.out.println(s);//RjS7S
    }
}
