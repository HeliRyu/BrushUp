import java.util.*;

/*
【题目】：
幼儿园两个班的小朋友在排队时混在了一起，每位小朋友都知道自己是否与前面一位小朋友是否同班，请你帮忙把同班的小朋友找出来。
小朋友的编号为整数，与前一位小朋友同班用Y表示，不同班用N表示。
【输入描述】:
输入为空格分开的小朋友编号和是否同班标志。
比如：6/N 2/Y 3/N 4/Y，表示共4位小朋友，2和6同班，3和2不同班，4和3同班。
其中，小朋友总数不超过999，每个小朋友编号大于0，小于等于999。
不考虑输入格式错误问题。
【输出描述】:
输出为两行，每一行记录一个班小朋友的编号，编号用空格分开。且：
1、编号需要按照大小升序排列，分班记录中第一个编号小的排在第一行。
2、若只有一个班的小朋友，第二行为空行。
3、若输入不符合要求，则直接输出字符串ERROR。
 */
public class DividingIntoClasses {
    private static StringBuilder groupA = new StringBuilder(), groupB = new StringBuilder();
    private static int flagId;//表示当前班级标识
    private static int firstChildId;// 第一个小朋友编号
    private static int everyChildId;// 第二位开始每个小朋友编号

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] childArray = scanner.nextLine().split(" ");
        if (childArray.length <= 999) {
            firstChildId = Integer.valueOf((childArray[0].split("/")[0]));
            if (firstChildId > 0 && firstChildId <= 999) {
                groupA.append(childArray[0].split("/")[0]).append(" ");
                flagId = 0;
                for (int i = 1; i < childArray.length; i++) {
                    everyChildId = Integer.valueOf((childArray[i].split("/")[0]));
                    if (everyChildId > 0 && everyChildId <= 999) {
                        String[] childInfoArray = childArray[i].split("/");
                        if (childInfoArray[1].equals("Y")) {
                            if (flagId == 0) {
                                groupA.append(childInfoArray[0]).append(" ");//A班
                            } else {
                                groupB.append(childInfoArray[0]).append(" ");//B班
                            }
                        } else {
                            if (flagId == 0) {
                                groupB.append(childInfoArray[0]).append(" ");
                            } else {
                                groupA.append(childInfoArray[0]).append(" ");
                            }
                            flagId = 1;
                        }
                    } else {
                        System.out.println("Error");
                        return;
                    }
                }
                sortChild(groupA);
                sortChild(groupB);
            } else {
                System.out.println("Error");
            }
        } else {
            System.out.println("Error");
        }
    }

    public static void sortChild(StringBuilder group) {
        List<String> groupAList = Arrays.asList(group.toString().split(" "));
        Collections.sort(groupAList);
        group.setLength(0);
        for (int i = 0; i < groupAList.size(); i++) {
            group.append(groupAList.get(i)).append(" ");
        }
        System.out.println(group);
    }
}

