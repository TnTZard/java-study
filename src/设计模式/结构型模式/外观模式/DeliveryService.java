package 设计模式.结构型模式.外观模式;

/**
 * @Author: anzhi
 * @Date: 2020/12/24 10:32
 */
public class DeliveryService {

    public void delivery(Takeaway takeaway) {
        System.out.println(takeaway.getName() + "订单派送中");
    }

}
