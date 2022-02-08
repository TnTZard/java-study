package database;

/**
 * @author xiezq1
 * @version 1.0.0
 * @date 2021/7/21 18:14
 */
public class Test {

    public static void main(String[] args) {
        String ddl = "create table BC_AGREE_REG_REL\n" +
                "(\n" +
                "\tREL_ID NUMBER(32) not null\n" +
                "\t\tprimary key,\n" +
                "\tREG_ID NUMBER(32) not null,\n" +
                "\tAGREE_ID NUMBER(32) not null,\n" +
                "\tCREATE_BY VARCHAR2(50),\n" +
                "\tCREATE_DATE DATE,\n" +
                "\tUPDATE_BY VARCHAR2(50),\n" +
                "\tUPDATE_DATE DATE\n" +
                ");\n" +
                "\n" +
                "comment on table BC_AGREE_REG_REL is '协议登记关联关系';\n" +
                "\n" +
                "comment on column BC_AGREE_REG_REL.REL_ID is '协议关联关系ID';\n" +
                "\n" +
                "comment on column BC_AGREE_REG_REL.REG_ID is '登记ID';\n" +
                "\n" +
                "comment on column BC_AGREE_REG_REL.AGREE_ID is '协议ID';\n" +
                "\n" +
                "comment on column BC_AGREE_REG_REL.CREATE_BY is '创建用户的帐号';\n" +
                "\n" +
                "comment on column BC_AGREE_REG_REL.CREATE_DATE is '创建时间';\n" +
                "\n" +
                "comment on column BC_AGREE_REG_REL.UPDATE_BY is '修改用户的帐号';\n" +
                "\n" +
                "comment on column BC_AGREE_REG_REL.UPDATE_DATE is '修改时间';";


        String s1 = "三方接口模版-20210722.xlsx";
        System.out.println(s1.split("."));

    }

    /**
     * 解析主键字段
     *
     * @param ddl
     * @return
     */
    public static String analyzePk(String ddl) {
        return "";
    }



}
