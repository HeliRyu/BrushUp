import java.util.Scanner;

public class JudgesScores {
    /*
     * 6名评委给选手打分，分数范围为[0,100]的整数。
     * 计算选手最后得分，即去掉一个最高分和最低分后的平均分。
     * */
    public static void main(String[] args) {
        //1)评委打分数组
        int arrScore[] = getScores();
        for (int i = 0; i < arrScore.length; i++) {
            System.out.println("第" + (i + 1) + "评委的打分是" + arrScore[i] + ",");
        }
        //2)求最高分
        int scoreMax = getScoreMax(arrScore);
        //3)求最低分
        int scoreMin = getScoreMin(arrScore);
        //4)求数组分数的总和
        int scoreSum = getScoreSum(arrScore);
        //5)求去掉一个最高分和最低分后的平均分
        int scoreAvg = (scoreSum - scoreMax - scoreMin) / (arrScore.length - 2);
        System.out.println("选手的最终得分是" + scoreAvg);
    }

    //求数组分数的总和
    public static int getScoreSum(int[] arrScore) {
        int sum = 0;
        for (int i = 0; i < arrScore.length; i++) {
            sum = sum + arrScore[i];
        }
        return sum;
    }

    //求最大值
    public static int getScoreMax(int[] arrScore) {
        int max = arrScore[0];
        //从自身后一个数开始比较
        for (int i = 1; i < arrScore.length; i++) {
            if (arrScore[i] > max) {
                max = arrScore[i];
            }
        }
        System.out.println("选手的最高分是" + max);
        return max;
    }

    //求最小值
    public static int getScoreMin(int[] arrScore) {
        int min = arrScore[0];
        for (int i = 1; i < arrScore.length; i++) {
            if (arrScore[i] < min) {
                min = arrScore[i];
            }
        }
        System.out.println("选手的最低分是" + min);
        return min;
    }

    //评委打分数组
    public static int[] getScores() {
        int[] scores = new int[6];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < scores.length; ) {
            System.out.println("请输入第" + (i + 1) + "评委的打分");
            int scoreInput = sc.nextInt();
            if (scoreInput >= 0 && scoreInput <= 100) {
                scores[i] = scoreInput;
                i++;
            } else {
                System.out.println("评委打分有误");
            }
        }
        return scores;
    }
}
