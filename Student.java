public class Student {
    /*
     * 定义数组存储4个学生的对象。
     * 学生属性:姓名、年龄、性别、爱好。
     * 要求1：计算出4个学生的平均年龄
     * 要求2：统计年龄比平均值低的学生有几个？并把他们的所有信息打印出来。
     * */
    private String name;
    private int age;
    private String gender;
    private String hobby;

    public Student() {
    }

    public Student(String name, int age, String gender, String hobby) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
