import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    //★★★修改方法名，启动学生管理系统
    public static void startStudentSystem() {
        //public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        loop:
        while (true) {
            System.out.println("------------欢迎来到学生管理系统-------------");
            System.out.println("1：添加学生");
            System.out.println("2：删除学生");
            System.out.println("3：修改学生");
            System.out.println("4：查询学生");
            System.out.println("5：退出");
            System.out.println("请输入您的选择：");
            Scanner sc = new Scanner(System.in);
            //不使用nextInt()，扩大选择范围
            String choose = sc.next();
            switch (choose) {
                case "1" -> addStudent(list);
                case "2" -> deleteStudent(list);
                case "3" -> updateStudent(list);
                case "4" -> queryStudent(list);
                case "5" -> {
                    System.out.println("退出");
                    //★★★使用loop标记跳出到指定层。否则只能跳出当前循环。
                    //break loop;
                    System.exit(0);//★★★停止虚拟机运行
                }
                default -> System.out.println("没有这个选项");
            }
        }
    }

    //添加学生
    public static void addStudent(ArrayList<Student> list) {
        /*//1）第一种方法：后创建学生对象
        System.out.println("添加学生");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生的id");
        String id = sc.next();
        System.out.println("请输入学生的姓名");
        String name = sc.next();
        System.out.println("请输入学生的年龄");
        int age = sc.nextInt();
        System.out.println("请输入学生的家庭住址");
        String address = sc.next();
        Student s = new Student(id, name, age, address);
        //把学生对象添加到集合中
        list.add(s);
        //提示添加成功
        System.out.println("学生信息添加成功");*/
        //2）第二种方法：先创建学生对象
        //利用空参构造先创建学生对象
        Student s = new Student();
        Scanner sc = new Scanner(System.in);

        //★★★设置id变量
        String id = null;
        while (true) {
            System.out.println("请输入学生的id");
            id = sc.next();
            boolean flag = containsId(list, id);
            if (flag) {
                //表示id已存在，需要重新输入
                System.out.println("学生id已存在，请重新输入");
            } else {
                //表示id不存在，可以使用
                s.setId(id);
                break;
            }
        }

        System.out.println("请输入学生的姓名");
        String name = sc.next();
        s.setName(name);

        System.out.println("请输入学生的年龄");
        int age = sc.nextInt();
        s.setAge(age);

        System.out.println("请输入学生的家庭住址");
        String address = sc.next();
        s.setAddress(address);

        list.add(s);
        System.out.println("学生信息添加成功");
    }

    //删除学生
    public static void deleteStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的id");
        String id = sc.next();
        //查询id在集合中的索引
        int index = getIndex(list, id);
        //对index进行判断
        //如果索引为-1，表示id不存在，结束方法，回到初始菜单
        if (index >= 0) {
            list.remove(index);
            System.out.println("已删除id为" + id + "的学生");
        } else {
            System.out.println("输入的学生id不存在，删除失败");
        }
    }

    //修改学生
    public static void updateStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改学生的id");
        String id = sc.next();
        int index = getIndex(list, id);
        if (index == -1) {
            System.out.println("要修改的id" + id + "不存在，请重新输入");
            return;
        }
        //id存在，获取要修改的学生对象
        Student s = list.get(index);
        //输入其他信息并修改
        System.out.println("请输入要修改的学生姓名");
        String name = sc.next();
        s.setName(name);
        System.out.println("请输入要修改的学生年龄");
        int age = sc.nextInt();
        s.setAge(age);
        System.out.println("请输入要修改的学生家庭住址");
        String address = sc.next();
        s.setAddress(address);
        System.out.println("学生信息修改成功");
    }

    //查询学生
    public static void queryStudent(ArrayList<Student> list) {
        System.out.println("查询学生");
        if (list.size() == 0) {
            System.out.println("当前无学生信息，请添加后再查询");
            //★★★结束方法
            return;
        }
        //★★★打印表头信息 \t
        System.out.println("id\t姓名\t年龄\t家庭住址");
        //当代码执行到这里，表示集合中是有数据的
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t" + stu.getAddress());
        }
    }

    //判断id在集合中是否存在
    public static boolean containsId(ArrayList<Student> list, String id) {
        /*//循环遍历集合拿到里面每一个学生对象
        for (int i = 0; i < list.size(); i++) {
            Student s = list.get(i);
            //拿到学生对象后，获取id进行判断
            String uid = s.getId();
            if (uid.equals(id)) {
                //学生id已在集合里存在，返回true
                return true;
            }
        }
        //不存在相同id返回false
        return false;*/
        return getIndex(list, id) >= 0;
    }

    //通过id获取索引
    public static int getIndex(ArrayList<Student> list, String id) {
        //遍历集合
        for (int i = 0; i < list.size(); i++) {
            //得到每一个学生对象
            Student s = list.get(i);
            //得到每一个学生对象的id
            String uid = s.getId();
            //拿着集合中的学生id与要删除的id进行比较
            if (uid.equals(id)) {
                // 如果一样，id存在，可以删除，返回此学生对象的索引
                return i;
            }
        }
        //循环结束，无相同id，没有找到要删除的学生对象，无法删除
        return -1;
    }
}
