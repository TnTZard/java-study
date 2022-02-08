package 常用常查.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author: anzhi
 * @Date: 2021/4/9 9:37
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    // 八种基本数据类型
    int intValue();
    long longValue();
    float floatValue();
    double doubleValue();
    char charValue();
    byte byteValue();
    short shortValue();
    boolean boolValue();

    // String
    String name();

    // 枚举
    CityEnum cityName();

    // Class类型
    Class clazz();

    // 注解
    MyAnnotation2 annotation2();

    // 以上几种的一维数组



}
