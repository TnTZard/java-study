package 设计模式.结构型模式.享元模式;

import java.time.LocalDateTime;

/**
 * @Author: anzhi
 * @Date: 2020/12/24 11:12
 */
public class FruitPie implements Pie {

    private String name;
    private LocalDateTime productTime;

    public FruitPie(String name) {
      this.name = name;
    }

    @Override
    public void make() {
        try {
            Thread.sleep(100);
            System.out.println(name + "生产时间：" + this.productTime);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    public void setProductTime(LocalDateTime productTime) {
        this.productTime = productTime;
    }
}
