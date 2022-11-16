public class ReplaceSensitiveWords {
    public static void main(String[] args) {
        //1.获取到说的话
        String words = "以下是敏感词，ABC，CC，AAA";
        //2.定义一个敏感词库
        String[] arr = {"ABC", "CC", "AAA"};
        //3.循环得到数组中的每一个敏感词，依次进行替换
        for (int i = 0; i < arr.length; i++) {
            words = words.replace(arr[i], "***");
        }
        //4.打印结果
        System.out.println(words);
    }
}
