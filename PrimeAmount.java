public class PrimeAmount {
    /*
     * 计算101~200之间素数的个数，并打印所有的素数。
     * */
    public static void main(String[] args) {
        int count = 0;
        //遍历101~200
        for (int i = 101; i < 201; i++) {
            //默认为质数
            boolean flag = true;
            //判断当前数是否为质数
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    //跳出单层循环
                    break;
                }
            }
            if (flag) {
                count++;
                System.out.println(i + "是第" + count + "个质数");
            }
        }
        System.out.println("101~200之间共有" + count + "个质数");
    }
}
