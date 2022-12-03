import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("欢迎来到学生管理系统");
            System.out.println("请选择操作：1.登录 2.注册 3.忘记密码");
            String choose = sc.next();
            switch (choose) {
                case "1" -> login(list);
                case "2" -> register(list);
                case "3" -> forgetPassword(list);
                case "4" -> {
                    System.out.println("谢谢使用，再见");
                    System.exit(0);
                }//大括号不能省略
                default -> System.out.println("没有这个选项");
            }
        }
    }

    private static void forgetPassword(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.next();
        boolean flag = contains(list, username);
        if (!flag) {
            System.out.println("当前用户" + username + "未注册，请先注册");
            return;
        }
        //键盘录入身份证号和手机号
        System.out.println("请输入身份证号码");
        String personID = sc.next();
        System.out.println("请输入手机号码");
        String phoneNumber = sc.next();
        //比较用户对象中的手机号码和身份证号码是否相同
        //需要把用户对象通过索引先获取出来
        int index = findIndex(list, username);
        User user = list.get(index);
        //比较用户对象中的手机号码和身份证号码是否相同
        //★★★身份证号码最后一位可能是x，所以忽略大小写
        //★★★取反比较，增强代码阅读性
        if (!(user.getPersonID().equalsIgnoreCase(personID) && user.getPhoneNumber().equals(phoneNumber))) {
            System.out.println("身份证号码或手机号码输入有误，不能修改密码");
            return;
        }
        //当代码执行到这里，表示所有数据验证成功，直接修改
        String password;
        while (true) {
            System.out.println("请输入新的密码");
            password = sc.next();
            System.out.println("请再次输入新的密码");
            String againPassword = sc.next();
            if (password.equals(againPassword)) {
                System.out.println("两次密码输入一致");
                break;
            } else {
                System.out.println("两次密码输入不一致，请重新输入");
                continue;
            }
        }
        //直接修改密码
        user.setPassword(password);
        System.out.println("密码修改成功");
    }

    private static int findIndex(ArrayList<User> list, String username) {
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            if (user.getUsername().equals(username)) {
                return i;
            }
        }
        return -1;
    }

    private static void register(ArrayList<User> list) {
        //1.键盘录入用户名
        Scanner sc = new Scanner(System.in);
        String username;
        while (true) {
            System.out.println("请输入用户名");
            username = sc.next();
            //开发细节：先验证格式是否正确，再验证是否唯一
            //因为存储在数据库中，如果要校验，需要使用到网络资源
            boolean flagCheckUsername = checkUsername(username);
            if (!flagCheckUsername) {
                System.out.println("用户名格式不满足条件，需要重新输入");
                continue;
            }
            //校验用户名唯一
            //username到集合中判断是否有存在
            boolean flagContainsUsername = contains(list, username);
            if (flagContainsUsername) {
                //用户名已存在，当前用户名无法注册，需要重新输入
                System.out.println("用户名" + username + "已存在，请重新输入");
            } else {
                //不存在，表示当前用户名可用，可以继续录入下面的其他数据
                System.out.println("用户名" + username + "可用");
                break;
            }
        }
        //2.键盘录入密码
        //密码键盘输入两次，两次一致才可以注册
        String password;
        while (true) {
            System.out.println("请输入要注册的密码");
            password = sc.next();
            System.out.println("请再次输入要注册的密码");
            String againPassword = sc.next();
            if (!password.equals(againPassword)) {
                System.out.println("两次密码输入不一致，请重新输入");
                continue;
            } else {
                System.out.println("两次密码一致，继续录入其他数据");
                break;
            }
        }
        //3.键盘录入身份证号码
        String personID;
        while (true) {
            System.out.println("请输入身份证号码");
            personID = sc.next();
            boolean flagCheckPersonID = checkPersonID(personID);
            if (flagCheckPersonID) {
                System.out.println("身份证号码满足要求");
                break;
            } else {
                System.out.println("身份证号码格式有误，请重新输入");
                continue;
            }
        }
        //4.键盘录入手机号码
        String phoneNumber;
        while (true) {
            System.out.println("请输入手机号码");
            phoneNumber = sc.next();
            boolean flagCheckPhoneNumber = checkPhoneNumber(phoneNumber);
            if (flagCheckPhoneNumber) {
                System.out.println("手机号码格式正确");
                break;
            } else {
                System.out.println("手机号码格式有误，请重新输入");
                continue;
            }
        }
        //用户名，密码，身份证号码，手机号码放到用户对象中
        User u = new User(username, password, personID, phoneNumber);
        //把用户对象添加到集合中
        list.add(u);
        System.out.println("注册成功");
        //遍历集合
        printList(list);
    }

    private static void printList(ArrayList<User> list) {
        for (int i = 0; i < list.size(); i++) {
            User u = list.get(i);
            System.out.println(u.getUsername() + "," + u.getPassword() + ","
                    + u.getPersonID() + "," + u.getPhoneNumber());
        }
    }

    private static boolean checkPhoneNumber(String phoneNumber) {
        //长度为11位
        if (phoneNumber.length() != 11) {
            return false;
        }
        //不能以0数字开头
        if (phoneNumber.startsWith("0")) {
            return false;
        }
        //必须都是数字
        for (int i = 0; i < phoneNumber.length(); i++) {
            char c = phoneNumber.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        //当循环结束之后，表示每一个字符都在0-9之间
        return true;
    }

    private static boolean checkPersonID(String personID) {
        //长度为18
        if (personID.length() != 18) {
            return false;
        }
        //不能以0数字开头
        if (personID.startsWith("0")) {
            return false;
        }
        //前17位，必须都是数字
        for (int i = 0; i < personID.length() - 1; i++) {
            char c = personID.charAt(i);
            //如果有一个字符不在0-9之间，返回false
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        //最后一位可以是数字，也可以是大写X或小写x
        char endPersonIDChar = personID.charAt(personID.length() - 1);
        if ((endPersonIDChar >= '0' && endPersonIDChar <= '9') || (endPersonIDChar == 'x') || (endPersonIDChar == 'X')) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean contains(ArrayList<User> list, String username) {
        //循环遍历集合得到每一个用户对象
        //拿着用户对象中的用户名进行比较
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            String rightUsername = user.getUsername();
            if (rightUsername.equals(username)) {
                return true;
            }
        }
        //当循环结束了，表示集合里面所有的用户都比较完毕了，还没有一样的，返回false
        return false;
    }

    private static boolean checkUsername(String username) {
        //用户名长度必须在3~15位之间
        int len = username.length();//减少后面调用方法的次数提高效率
        if (len < 3 || len > 15) {
            return false;
        }
        //★★当代码执行到这里，表示用户名的长度是符合要求的
        //继续校验：只能是字母+数字的组合
        //循环得到username里的每一个字符，如果有一个字符不是字母或者数字，返回false
        for (int i = 0; i < username.length(); i++) {
            // i 索引
            char c = username.charAt(i);
            //★★★！表示取反，不存在，注意括号数量
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))) {
                return false;
            }
        }
        //★★当代码执行到这里，表示用户名满足长度和字符+数字的要求
        //但不能是纯数字
        //统计在用户名中，有多少字母
        int count = 0;
        for (int i = 0; i < username.length(); i++) {
            // i 索引
            char c = username.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                count++;
                //★★★当有一个存在，直接退出，提高效率 a123
                break;
            }
        }
        //★★★如果字母存在，返回true
        return count > 0;
    }

    private static void login(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入用户名");
            String username = sc.next();
            //判断用户名是否存在
            boolean flag = contains(list, username);
            if (!flag) {
                System.out.println("用户名" + username + "未注册，请先注册再登录");
                return;//结束方法
            }
            System.out.println("请输入密码");
            String password = sc.next();
            while (true) {
                String rightCode = getCode();
                System.out.println("当前正确的验证码为" + rightCode);
                System.out.println("请输入验证码");
                String code = sc.next();
                //验证码忽略大小写
                if (code.equalsIgnoreCase(rightCode)) {
                    System.out.println("验证码正确");
                    break;
                } else {
                    System.out.println("验证码错误");
                    continue;
                }
            }
            //验证用户名和密码是否正确
            //集合中是否包含用户名和密码
            //定义一个方法验证用户名和密码是否正确
            //★★★封装思想的应用：
            //我们可以把一些零散的数据，封装成一个对象
            //传递参数时，传递一个整体
            User userInfo = new User(username, password, null, null);
            boolean result = checkUserInfo(list, userInfo);
            if (result) {
                System.out.println("登录成功，可以开始使用学生系统了");
                //★★★★★★创建对象调用方法，启动学生管理系统
                StudentSystem ss = new StudentSystem();
                ss.startStudentSystem();
                break;
            } else {
                System.out.println("登录失败，用户名或密码错误");
                if (i == 2) {
                    System.out.println("当前账号" + username + "被锁定，请联系客服：xxx-xxxxx");
                    //当前账号锁定之后，直接结束方法即可
                    return;
                } else {
                    System.out.println("用户名或密码错误，还剩下" + (2 - i) + "次机会");
                }
            }
        }
    }

    private static boolean checkUserInfo(ArrayList<User> list, User userInfo) {
        //遍历集合，判断用户是否存在，如果存在登录成功，如果不存在登录失败
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            if (user.getUsername().equals(userInfo.getUsername()) && user.getPassword().equals(userInfo.getPassword())) {
                return true;
            }
        }
        return false;
    }

    //生成一个验证码
    private static String getCode() {
        //1.创建一个集合添加所有的大写和小写字母，因为多次所以此处不添加数字
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            //★★★添加大小写字符
            list.add((char) ('a' + i));
            list.add((char) ('A' + i));
        }
        //拼接字符
        StringBuilder sb = new StringBuilder();
        //2.要随机抽取4个字符
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            //获取随机索引
            int randomIndex = r.nextInt(list.size());
            //利用随机索引获取字符
            //Character是类，char基本数据类型
            //★★★JDK5.0后,char可以自动包装成Character;Character也可以自动拆包成char
            char c = list.get(randomIndex);
            sb.append(c);
        }
        //3.把一个随机数字添加到末尾
        int number = r.nextInt(10);
        sb.append(number);
        //4.修改字符串内容
        //先把字符串变成字符数组，在数组中修改，然后再创建一个新的字符串】
        char[] arr = sb.toString().toCharArray();
        //获取随机索引
        int randomIndex = r.nextInt(arr.length);
        //最大索引指向的数字，和随机索引指向的元素交换
        char temp = arr[arr.length - 1];
        arr[arr.length - 1] = arr[randomIndex];
        arr[randomIndex] = temp;
        return new String(arr);
    }
}
