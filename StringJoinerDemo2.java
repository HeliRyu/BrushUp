import java.util.StringJoiner;

public class StringJoinerDemo2 {
    public static void main(String[] args) {
        //1.创建对象
        StringJoiner sj = new StringJoiner(",", "[", "]");
        //2.添加元素
        sj.add("aaa").add("bbb").add("ccc");
        //3.打印
        System.out.println(sj);//[aaa,bbb,ccc]
        //长度
        int len = sj.length();
        System.out.println(len);//13
        //toString方法
        String str = sj.toString();
        System.out.println(str);//[aaa,bbb,ccc]
    }
}
