public class SpendMoneyGame {
    public static void main(String[] args) {
        //1.创建第一个角色
        Role r1 = new Role("尉迟轩", 100000, '男');
        //2.创建第二个角色
        Role r2 = new Role("晏乐儿", 100000, '女');
        //3.展示角色信息
        r1.showRoleInfo();
        r2.showRoleInfo();
        //4.开始花钱游戏
        while (true) {
            r1.spendMoney(r2);
            if (r2.getMoney() == 0) {
                System.out.println(r1.getName() + "花光了" + r2.getName() + "的钱");
                break;
            }
            r2.spendMoney(r1);
            if (r1.getMoney() == 0) {
                System.out.println(r2.getName() + "花光了" + r1.getName() + "的钱");
                break;
            }
        }
    }
}
