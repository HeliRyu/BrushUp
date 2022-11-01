public class StudentStorage {
    public static void main(String[] args) {
        /*
         * 定义一个长度为3的数组，数组存储1~3名学生对象作为初始数据。学生对象的学号、姓名各不相同。
         * 学生的属性：学号，姓名，年龄。
         * 要求1：再次添加一个学生对象，并在添加的时候进行学号的唯一性判断。
         * 要求2：添加完毕之后，遍历所有学生信息。
         * 要求3：通过id删除学生信息。
         *       如果存在，则删除。如果不存在，则提示删除失败。
         * 要求4: 删除完毕之后，遍历所有学生信息。
         * 要求5：查询数组id为：“1”的学生，如果存在，则将他的年龄+1岁。
         * */
        //定义一个长度为3的数组，数组存储1~3名学生对象作为初始数据。学生对象的属性各不相同。
        //1.创建一个长度为3的数组用来存储学生对象
        StudentStorageBean[] arrStudent = new StudentStorageBean[3];
        //学生的属性：学号，姓名，年龄。
        //2.创建学生对象并添加到数组当中
        StudentStorageBean stu1 = new StudentStorageBean(1, "忍冬", 23);
        StudentStorageBean stu2 = new StudentStorageBean(2, "巫哲", 24);
        StudentStorageBean stu3 = new StudentStorageBean(3, "华筝", 25);
        //3.把学生对象添加到数组当中
        arrStudent[0] = stu1;
        arrStudent[1] = stu2;
        arrStudent[2] = stu3;
        //4.要求1：再次添加一个学生对象，并在添加的时候进行学号的唯一性判断。
        //创建一个学生对象
        StudentStorageBean stu4 = new StudentStorageBean(4, "子柏", 26);
        //进行学号的唯一性判断
        boolean flag = contains(arrStudent, stu4.getId());
        if (flag) {
            //1）已存在---不用添加
            System.out.println("当前id重复，请修改id后再进行添加");
        } else {
            //2）不存在---把学生对象stu4添加进数组
            int count = getCount(arrStudent);
            if (count == arrStudent.length) {
                //1））数组已经存满---只能创建一个新的数组，新数组的长度=老数组+1
                //将旧数组的元素拷贝到新数组当中
                StudentStorageBean[] newArrStu = createNewArr(arrStudent);
                newArrStu[count] = stu4;
                //要求2：添加完毕之后，遍历所有学生信息。
                printArr(newArrStu);
            } else {
                //2））数组没有存满---直接添加
                //★★★getCount获取到的count，表示数组当中已经有几个元素，下一次添加数据的索引也是count
                arrStudent[count] = stu4;
                //要求2：添加完毕之后，遍历所有学生信息。
                printArr(arrStudent);
            }
        }
        //5.要求3：通过id删除学生信息。如果存在，则删除。如果不存在，则提示删除失败。
        //要找到id在数组中对应的索引
        // ◆练习用直接取数组arrStudent
        int index = getIndex(arrStudent, 2);
        if (index >= 0) {
            //索引存在，则删除，即设置为null。
            arrStudent[index] = null;
            //要求4: 删除完毕之后，遍历所有学生信息。
            printArr(arrStudent);
        } else {
            //索引不存在，提示删除失败
            System.out.println("当前id不存在，删除失败");
        }
        //要求5：查询数组id为：“1”的学生，如果存在，则将他的年龄+1岁。
        //1）先找到id为1的学生对应的索引
        int indexStu2 = getIndex(arrStudent, 1);
        //2）判断索引
        if (indexStu2 >= 0) {
            //索引存在，获取对象
            StudentStorageBean stu = arrStudent[indexStu2];
            //计算新年龄
            int newAge = stu.getAge() + 1;
            //设置新年龄
            stu.setAge(newAge);
            printArr(arrStudent);
        } else {
            //索引不存在，直接提示
            System.out.println("当前id不存在，修改失败");
        }
    }

    //找到id在数组中对应的索引
    public static int getIndex(StudentStorageBean[] arr, int id) {
        for (int i = 0; i < arr.length; i++) {
            //依次得到每一个学生对象
            StudentStorageBean stu = arr[i];
            //对stu进行一个非空判断
            if (stu != null) {
                int sid = stu.getId();
                if (sid == id) {
                    return i;
                }
            }
        }
        //循环结束后，还未找到相同id则为不存在这个id对象。由于索引不存在-1所以返回-1。
        return -1;
    }

    //遍历所有学生信息
    public static void printArr(StudentStorageBean[] arr) {
        for (int i = 0; i < arr.length; i++) {
            StudentStorageBean stu = arr[i];
            if (stu != null) {
                System.out.println(stu.getId() + "," + stu.getName() + "," + stu.getAge());
            }
        }
    }

    //创建长度+1的新数组
    public static StudentStorageBean[] createNewArr(StudentStorageBean[] arrStudent) {
        StudentStorageBean[] newArrStudent = new StudentStorageBean[arrStudent.length + 1];
        //循环遍历得到旧数组中每一个元素
        for (int i = 0; i < arrStudent.length; i++) {
            //把旧数组中的元素添加到新数组中
            newArrStudent[i] = arrStudent[i];
        }
        return newArrStudent;
    }

    //判断数组中已经存在的元素数量
    public static int getCount(StudentStorageBean[] arrStudent) {
        //定义一个计数器用来统计
        int count = 0;
        for (int i = 0; i < arrStudent.length; i++) {
            if (arrStudent[i] != null) {
                count++;
            }
        }
        return count;
    }

    //id唯一性判断
    public static boolean contains(StudentStorageBean[] arrStudent, int id) {
        for (int i = 0; i < arrStudent.length; i++) {
            //依次获取数组里面的每一个学生对象
            StudentStorageBean stu = arrStudent[i];
            //★★★判断数组里对象是否为空
            if (stu != null) {
                //获取数组中学生对象的id
                int sid = stu.getId();
                //比较
                if (sid == id) {
                    return true;
                }
            }
        }
        //当循环结束之后，还没有找到一样id时，表示是此id是唯一的。
        return false;
    }
}
