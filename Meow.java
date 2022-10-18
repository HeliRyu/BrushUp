public class Meow {
    /*
     * 打印1~100，当数字包含7或是7的倍数的时候打印“喵”。
     * */
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            //个位为7或十位为7或为7的倍数。
            if (i % 10 == 7 || i / 10 % 10 == 7 || i % 7 == 0) {
                System.out.println("喵");
                continue;
            }
            System.out.println(i);
        }
    }
}
