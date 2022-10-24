public class PhoneTest {
    public static void main(String[] args) {
        //1.创建一个数组
        Phone[] arr = new Phone[3];
        //2.创建手机的对象
        Phone p1 = new Phone("小米", 2000, "白色");
        Phone p2 = new Phone("华为", 3000, "红色");
        Phone p3 = new Phone("苹果", 4000, "紫色");
        //3.把手机对象添加到数组当中
        arr[0] = p1;
        arr[1] = p2;
        arr[2] = p3;
        //4.获取三部手机的平均价格
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            Phone phone = arr[i];
            sum = sum + phone.getPrice();
        }
        //5.求平均值
        int avg = sum / arr.length;
        double avg2 = sum * 1.0 / arr.length;
        System.out.println(avg2);
    }
}
