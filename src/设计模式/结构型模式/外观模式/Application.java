package 设计模式.结构型模式.外观模式;

/**
 * @Author: anzhi
 * @Date: 2020/12/24 10:37
 */
public class Application {

    public static void main(String[] args) {
        Takeaway takeaway = new Takeaway();
        takeaway.setName("TIGA");
        TakeawayService takeawayService = new TakeawayService();
        takeawayService.takeOrder(takeaway);
    }

}
