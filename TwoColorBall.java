import java.util.Random;
import java.util.Scanner;

public class TwoColorBall {
    /*
     * 投注号码由6个红球号码和1个蓝球号码组成。
     * 红球号码从1~33，蓝球从1~16中选择。
     *
     * */
    public static void main(String[] args) {
        //1)中奖号码
        int[] winningArray = createWinningNumber();
        //2)用户购买号码
        int[] userNumberArray = userInputNumber();
        //3)判断中奖情况
        //1.判断红球中奖个数
        int redCount = 0;
        for (int i = 0; i < userNumberArray.length - 1; i++) {
            for (int j = 0; j < winningArray.length - 1; j++) {
                if (userNumberArray[i] == winningArray[j]) {
                    redCount++;
                    break;
                }
            }
        }
        //2.判断蓝球中奖个数
        int blueCount = 0;
        if (userNumberArray[userNumberArray.length - 1] == winningArray[winningArray.length - 1]) {
            blueCount++;
        }
        //3.根据个数来判断中奖情况
        if (redCount == 6 && blueCount == 1) {
            System.out.println("中奖最高1000万元");
        } else if (redCount == 6 && blueCount == 0) {
            System.out.println("中奖最高500万元");
        } else if (redCount == 5 && blueCount == 1) {
            System.out.println("中奖3000元");
        } else if ((redCount == 5 && blueCount == 0) || (redCount == 4 && blueCount == 1)) {
            System.out.println("中奖200元");
        } else if ((redCount == 4 && blueCount == 0) || (redCount == 3 && blueCount == 1)) {
            System.out.println("中奖10元");
        } else if ((redCount == 2 && blueCount == 1) || (redCount == 1 && blueCount == 1) || (redCount == 0 && blueCount == 1)) {
            System.out.println("中奖5元");
        } else {
            System.out.println("谢谢参与");
        }
    }

    public static int[] userInputNumber() {
        //1.创建用户购买号码的数组，长度为7
        int[] userNumberArr = new int[7];
        //2.键盘录入号码，并添加到数组中
        Scanner sc = new Scanner(System.in);
        //3.录入生成红球购买号码,判断是否符合范围且已存在于数组中，如果没有就添加到数组中
        for (int i = 0; i < 6; ) {
            System.out.println("请输入第" + (i + 1) + "个红球号码");
            int userRedNumber = sc.nextInt();
            if (userRedNumber >= 1 && userRedNumber <= 33) {
                boolean ifuserRedExistential = ifExisted(userNumberArr, userRedNumber);
                if (!ifuserRedExistential) {
                    userNumberArr[i] = userRedNumber;
                    i++;
                } else {
                    System.out.println("当前红球号码已存在，请重新输入购买");
                }
            } else {
                System.out.println("当前红球号码不在范围中");
            }
        }
        //4.录入生成篮球购买号码
        System.out.println("请输入蓝球号码");
        while (true) {
            int userBlueNumber = sc.nextInt();
            if (userBlueNumber >= 1 && userBlueNumber <= 16) {
                userNumberArr[userNumberArr.length - 1] = userBlueNumber;
                break;
            } else {
                System.out.println("当前蓝球号码不在范围中");
            }
        }
        return userNumberArr;
    }

    public static int[] createWinningNumber() {
        //1.创建中奖数组，6个红球+1个篮球，数组长度为7
        int[] winningArr = new int[7];
        //2.随机生成红球中奖号码,判断是否已存在于数组中，如果没有就添加到数组中
        Random r = new Random();
        for (int i = 0; i < 6; ) {
            int redWinNumber = r.nextInt(33) + 1;
            boolean ifRedExistential = ifExisted(winningArr, redWinNumber);
            if (!ifRedExistential) {
                winningArr[i] = redWinNumber;
                i++;
            }
        }
        //3.随机生成蓝球号码并添加到中奖数组中，不必判断是否重复
        int blueWinNumber = r.nextInt(16) + 1;
        winningArr[winningArr.length - 1] = blueWinNumber;
        return winningArr;
    }

    //用于判断号码是否存在于数组中（判断是否重复）
    public static boolean ifExisted(int[] arr, int number) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                return true;
            }
        }
        return false;
    }
}