public class Car {
    /*
     * 定义数组存储3部汽车对象。
     * 汽车的属性：品牌，价格，颜色。
     * 创建三个汽车对象，数据通过键盘录入而来，并把数据存入到数组当中。
     * */

    /*
     * 键盘录入两套体系不能混用，例如先用nextInt再用nextLine会导致nextLine接收不到数据。
     * 第一套体系：遇到空格、制表符、回车就停止接收。
     * nextInt();接收整数
     * nextDouble();接收小数
     * next();接收字符串
     * 第二套体系:
     * nextLine();接收字符串
     * */

    private String brand;
    private int price;
    private String color;

    public Car() {
    }

    public Car(String brand, int price, String color) {
        this.brand = brand;
        this.price = price;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
