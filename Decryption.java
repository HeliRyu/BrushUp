public class Decryption {
    /*
     * 将加密方式反向进行解密。
     * */
    public static void main(String[] args) {
        //1)把需要解密的整数密码放入数组中
        //1.计算数组的长度
        int originalNumber = 8346;
        //定义一个临时变量记录number的值，为后续使用。
        int numberTemp = originalNumber;
        int count = 0;
        while (originalNumber != 0) {
            originalNumber = originalNumber / 10;
            count++;
        }
        //2.定义数组
        //动态初始化
        int[] arr = new int[count];
        //3.把整数上的每一位都放到数组中
        //★★★★★数组的索引从后往前
        int index = arr.length - 1;
        while (numberTemp != 0) {
            //获取个位数
            int singleDigit = numberTemp % 10;
            //原整数删去取得的个位数
            numberTemp = numberTemp / 10;
            arr[index] = singleDigit;
            index--;
        }
        //2)解密
        //1.反转
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        //2.加密是对10取余
        //★★★★★通过规律判断得出，解密即为0~4之间+10，5~9不变
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0 && arr[i] <= 4) {
                arr[i] = arr[i] + 10;
            }
        }
        //3.每一位数字减去5
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] - 5;
        }
        //4.获取数组里的每一位数字拼成整数
        int number = 0;
        for (int i = 0; i < arr.length; i++) {
            number = number * 10 + arr[i];
        }
        System.out.println("解密后的数字为" + number);
    }
}
