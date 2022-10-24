public class StudentTest {
    public static void main(String[] args) {
        //1.定义数组存入学生的对象
        Student[] arr = new Student[4];
        //2.创建学生对象
        Student s1 = new Student("小红", 19, "女", "看电影");
        Student s2 = new Student("小明", 20, "男", "看书");
        Student s3 = new Student("小花", 21, "女", "运动");
        Student s4 = new Student("小天", 22, "男", "吃饭");
        //3.把对象添加到数组中
        arr[0] = s1;
        arr[1] = s2;
        arr[2] = s3;
        arr[3] = s4;
        //4.求和
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            Student s = arr[i];
            sum = sum + s.getAge();
        }
        //5.平均值
        int avg = sum / arr.length;
        //6.统计年龄比平均值低的有几个，打印他们的信息
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            Student s = arr[i];
            if (s.getAge() < avg) {
                count++;
                System.out.println(s.getName() + "," + s.getAge() + "," + s.getGender() + "," + s.getHobby());
            }
        }
        System.out.println("年龄比平均值低的有" + count + "个");
    }
}

