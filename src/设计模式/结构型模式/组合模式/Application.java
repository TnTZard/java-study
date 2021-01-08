package 设计模式.结构型模式.组合模式;

/**
 * @Author: anzhi
 * @Date: 2020/12/24 14:18
 */
public class Application {

    public static void main(String[] args) {
        Menu userMenu = new Menu("用户管理", "\uD83E\uDDD1", 2);
        Button createUser = new Button("新增用户");
        Button updateUser = new Button("修改用户");
        Button deleteUser = new Button("删除用户");
        userMenu.add(createUser);
        userMenu.add(updateUser);
        userMenu.add(deleteUser);

        Menu logMenu = new Menu("操作日志", "\uD83D\uDCC3", 2);
        Button export = new Button("导出excel");
        logMenu.add(export);

        Menu systemMenu = new Menu("系统管理", "\uD83D\uDD28", 1);
        systemMenu.add(userMenu);
        systemMenu.add(logMenu);

        systemMenu.print();
    }

}
