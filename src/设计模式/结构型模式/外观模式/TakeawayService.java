package 设计模式.结构型模式.外观模式;

/**
 * @Author: anzhi
 * @Date: 2020/12/24 10:34
 */
public class TakeawayService {

    private OrderService orderService = new OrderService();
    private PayService payService = new PayService();
    private DeliveryService deliveryService = new DeliveryService();

    public void takeOrder(Takeaway takeaway) {
        if (orderService.placeAnOrder(takeaway)) {
            if (payService.pay(takeaway)){
                deliveryService.delivery(takeaway);
            }
        }
    }

}
