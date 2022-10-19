import java.util.Scanner;

public class AirlineTickets {
    /*
     * 计算机票价格。
     * 旺季（5~10月）头等舱9折，经济舱8.5折。
     * 淡季（11月~4月）头等舱7折，经济舱6.5折。
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入机票原价");
        int ticket = sc.nextInt();
        System.out.println("请输入当前月份");
        int month = sc.nextInt();
        System.out.println("请输入舱位信息 0头等舱 1经济舱");
        int aircraftClass = sc.nextInt();
        if (month >= 5 && month <= 10) {
            ticket = getTicket(aircraftClass, ticket, 0.9, 0.85);
            System.out.println("机票的价格为" + ticket);
        } else if ((month >= 1 && month <= 4) || (month >= 11 && month <= 12)) {
            ticket = getTicket(aircraftClass, ticket, 0.7, 0.65);
            System.out.println("机票的价格为" + ticket);
        } else {
            System.out.println("您输入的月份有误");
        }
    }

    private static int getTicket(int aircraftClass, int ticket, double discountFirst, double discountTourist) {
        if (aircraftClass == 0) {
            ticket = (int) (ticket * discountFirst);
        } else if (aircraftClass == 1) {
            ticket = (int) (ticket * discountTourist);
        } else {
            System.out.println("您输入的舱位有误");
        }
        return ticket;
    }
}