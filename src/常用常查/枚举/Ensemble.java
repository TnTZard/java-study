package 常用常查.枚举;

/**
 * @author xiezq1
 * @version 1.0.0
 * @date 2021/11/23 11:05
 */
public enum Ensemble {

    SOLID(1), DUET(2);

    private final int numberOfMusicians;

    Ensemble(int size) {
        this.numberOfMusicians = size;
    }

    public int number() {
        return numberOfMusicians;
    }




}
