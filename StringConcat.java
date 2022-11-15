public class StringConcat {
    /*
     * 定义一个方法，把int数组中的数据按照指定的格式拼接成一个字符串返回。
     * 调用该方法，并在控制台输出结果。
     * 例如：
     * 数组为int[] arr = {1, 2, 3};
     * 执行方法后的输出结果为：[1,2,3]
     * */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        String str = arrToString(arr);
        System.out.println(str);
    }

    public static String arrToString(int[] arr) {
        //数组为空
        if (arr == null) {
            return "";
        }
        //数组长度为0
        if (arr.length == 0) {
            return "[]";
        }
        String result = "[";
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                result = result + arr[i];
            } else {
                result = result + arr[i] + ",";
            }
        }
        result = result + "]";
        return result;
    }
}
