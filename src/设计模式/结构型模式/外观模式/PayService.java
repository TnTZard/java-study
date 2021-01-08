package 设计模式.结构型模式.外观模式;

/**
 * @Author: anzhi
 * @Date: 2020/12/24 10:25
 */
public class PayService {

    public boolean pay(Takeaway takeaway) {
        System.out.println("商品" + takeaway.getName() + "支付成功");
        return true;
    }

}
