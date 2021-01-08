package 设计模式.结构型模式.外观模式;

import java.lang.annotation.Target;

/**
 * @Author: anzhi
 * @Date: 2020/12/22 11:54
 */
public class OrderService {

    public boolean placeAnOrder(Takeaway takeaway) {
        System.out.println(takeaway.getName() + "下单成功");
        return true;
    }

}
