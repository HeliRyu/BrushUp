public class AdjustString {
    public static void main(String[] args) {
        //1.定义两个字符串
        String strA = "abcde";
        String strB = "cdeab";
        //2.调用方法进行比较
        boolean result = check(strA, strB);
        //3.输出
        System.out.println(result);//true
    }

    //循环旋转并比较
/*    调整次数和字符长度相同
    1:bcdea
    2:cdeab
    3:deabc
    4:eabcd
    5:abcde*/
    public static boolean check(String strA, String strB) {
        for (int i = 0; i < strA.length(); i++) {
            strA = rotateString(strA);
            if (strA.equals(strB)) {
                return true;
            }
        }
        //所有情况比较完毕，若未发现相同情况，则返回false
        return false;
    }

    //作用：旋转字符串，把左侧的字符移动到右侧去
    //形参：旋转前的字符串
    //返回值：旋转后的字符串
    public static String rotateString(String str) {
        //★★★修改字符串内容方法：
        //1）用subString进行截取，把左侧字符截取出来拼接到右侧
/*        //获取最左侧那个字符
        char first = str.charAt(0);
        //获取剩余字符
        String end = str.substring(1);
        return end + first;*/
        //2）将字符串变成字符数组，调整字符数组里的数据，再将字符数组变成字符串
        //"ABC"--> ['A','B','C']-->['B','C','A']--> new String(字符数组)
        char[] arr = str.toCharArray();
        //获取0位置索引上的字符
        char first = arr[0];
        //剩余字符往前挪一个索引
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        //将原来0位置索引上的字符放到最后一个索引
        arr[arr.length - 1] = first;
        //利用字符数组创建一个字符串对象
        String result = new String(arr);
        return result;
    }
}
