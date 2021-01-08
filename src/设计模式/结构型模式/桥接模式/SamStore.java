package 设计模式.结构型模式.桥接模式;

/**
 * @Author: anzhi
 * @Date: 2020/12/24 14:33
 */
public class SamStore extends Store {

    public SamStore(Pie pie) {
        super(pie);
    }


    @Override
    Pie makePie() {
        System.out.println("山姆大叔的小店\uD83D\uDC92");
        return pie.makePie();
    }
}
