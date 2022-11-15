public class StringReversal {
    public static void main(String[] args) {
        String result = reversal("abc");
        System.out.println(result);
    }

    public static String reversal(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            //i依次表示字符串中倒着的每一个索引
            char c = str.charAt(i);
            result = result + c;
        }
        return result;
    }
}
