package 设计模式.结构型模式.桥接模式;

/**
 * @Author: anzhi
 * @Date: 2020/12/24 14:35
 */
public class Application {

    public static void main(String[] args) {

        Store samStore = new SamStore(new ApplePie());
        Pie samStorePie = samStore.makePie();
        samStorePie.getType();

        Store jackStore = new JackStore(new CarrotPie());
        Pie jackStorePie = jackStore.makePie();
        jackStorePie.getType();

    }


}
