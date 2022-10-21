public class Encryption {
    /*
     * 某数字密码为大于0的整数，采用加密方式进行传输。
     * 加密规则：先得到每位数，每位数都加上5，再对10取余，最后将整串数字反转，得到一串新数。
     * */
    public static void main(String[] args) {
        //1)把整数密码放入数组中
        //1.计算数组的长度
        int originalNumber = 1983;
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
        //2)加密
        //1.每位数都加上5
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + 5;
        }
        //2.每位数对10取余
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] % 10;
        }
        //3.将整串数字反转（参考数组交换元素）
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        //4.把数组的每个数字拼接成为一个整数
        int number = 0;
        for (int i = 0; i < arr.length; i++) {
            //★★★★★
            number = number * 10 + arr[i];
        }
        System.out.println("加密后的数字为" + number);
    }
}
