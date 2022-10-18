import java.util.Scanner;

public class Vacation {
    /*
     * default可以写在任意位置，习惯写在最下面。可以省略，但不建议。
     * case穿透：如果多个case语句重复可以利用。继续执行下一格case语句直到遇到break或右大括号为止。
     * switch新特性：JDK12。
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("假期做什么呢？");
        int activity = sc.nextInt();
        switch (activity) {
            case 1, 2, 3, 4, 5 -> System.out.println("抓娃娃");
            case 6, 7 -> System.out.println("艺术博物馆");
            case 8 -> System.out.println("水族馆");
            default -> System.out.println("宅着打游戏");
        }
    }
}
