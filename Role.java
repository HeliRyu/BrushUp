import java.util.Random;

public class Role {
    private String name;
    private int money;
    private char gender;
    private String face;

    String[] maleAppearance = {"面目清秀", "温文尔雅", "玉树临风", "风度翩翩", "英俊潇洒"};
    String[] femaleAppearance = {"沉鱼落雁", "闭月羞花", "倾国倾城", "仪态万千", "如花似玉"};

    //花钱描述
    String[] spend_desc = {
            "%s买了高性价比大容量滚筒洗衣机，%s的钱包受到了攻击",
            "%s买了冰箱三开门 253升一级能效 节能变频，%s的钱包受到了攻击",
            "%s买了电视 55E8 55英寸 2+32GB 4K超高清全面屏 智慧屏，%s的钱包受到了攻击",
            "%s买了大1匹 云佳 新一级能效 变频冷暖 自清洁壁挂式空调，%s的钱包受到了攻击",
            "%s买了洗碗机台式家用4-6套高温除菌烘干智能超快洗易安装刷碗机，%s的钱包受到了攻击",
            "%s买了洗衣液和洁面慕斯，%s的钱包受到了攻击"
    };

    //被花钱的人感受描述
    String[] injure_desc = {
            "%s认为洒洒水啦",
            "%s说明天不吃晚饭了",
            "%s取消了买私人飞机的计划",
            "%s痛苦地闷哼了一声",
            "%s摇摇晃晃，辞退了管家",
            "%s开始找贷款消息",
            "%s把大别墅换成小房子",
            "%s收拾行李回家啃老",
    };

    public Role() {
    }

    public Role(String name, int money, char gender) {
        this.name = name;
        this.money = money;
        this.gender = gender;
        setFace(gender);
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getFace() {
        return face;
    }

    public void setFace(char gender) {
        Random r = new Random();
        if (gender == '男') {
            int index = r.nextInt(maleAppearance.length);
            this.face = maleAppearance[index];
        } else if (gender == '女') {
            int index = r.nextInt(femaleAppearance.length);
            this.face = femaleAppearance[index];
        } else {
            this.face = "面目狰狞";
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    //定义一个方法用于使用对方的钱
    public void spendMoney(Role role) {
        Random r = new Random();
        int index = r.nextInt(spend_desc.length);
        String shopping = spend_desc[index];
        //输出一个花钱的效果
        System.out.printf(shopping, this.getName(), role.getName());
        System.out.println();
        //每次花掉的钱
        int spend = r.nextInt(10000) + 1000;
        //剩余金钱
        int remainMoney = role.getMoney() - spend;
        //对剩余金钱做一个验证，如果为负数，就修改为0
        remainMoney = remainMoney < 0 ? 0 : remainMoney;
        //修改一下被花掉钱后那个人的金钱余额
        role.setMoney(remainMoney);
        //被花钱的描述
        if (remainMoney > 90000) {
            System.out.printf(injure_desc[0], role.getName());
        } else if (remainMoney > 80000 && remainMoney <= 90000) {
            System.out.printf(injure_desc[1], role.getName());
        } else if (remainMoney > 70000 && remainMoney <= 80000) {
            System.out.printf(injure_desc[2], role.getName());
        } else if (remainMoney > 60000 && remainMoney <= 70000) {
            System.out.printf(injure_desc[3], role.getName());
        } else if (remainMoney > 40000 && remainMoney <= 60000) {
            System.out.printf(injure_desc[4], role.getName());
        } else if (remainMoney > 20000 && remainMoney <= 40000) {
            System.out.printf(injure_desc[5], role.getName());
        } else if (remainMoney > 10000 && remainMoney <= 20000) {
            System.out.printf(injure_desc[6], role.getName());
        } else {
            System.out.printf(injure_desc[7], role.getName());
        }
        System.out.println();
    }

    public void showRoleInfo() {
        System.out.println("姓名为" + getName());
        System.out.println("余额为" + getMoney());
        System.out.println("性别为" + getGender());
        System.out.println("长相为" + getFace());
    }
}
