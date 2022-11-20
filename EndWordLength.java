public class EndWordLength {
    public static void main(String[] args) {
        String s = "Hello World";
        int count = 0;
        //倒着遍历
        for (int i = s.length() - 1; i >= 0; i--) {
            System.out.println(i);
            char a = s.charAt(i);
            //直到遇到空格位置
            if (a == ' ') {
                break;
            } else {
                count++;
            }
        }
        //那么遍历的次数就是单词的长度
        System.out.println(count);//5
    }
}
