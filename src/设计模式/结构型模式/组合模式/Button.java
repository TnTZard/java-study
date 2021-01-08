package 设计模式.结构型模式.组合模式;

/**
 * @Author: anzhi
 * @Date: 2020/12/24 11:31
 */
public class Button extends AbstractMenuButton{

    private String name;

    public Button(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getType() {
        return "按钮";
    }

    @Override
    public void print() {
        System.out.println(getName() + "[" + getType() + "]");
    }
}
