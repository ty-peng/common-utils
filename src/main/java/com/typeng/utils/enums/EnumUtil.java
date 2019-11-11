package com.typeng.utils.enums;

/**
 * 枚举通用工具类.
 *
 * @author ty-peng
 * @since 2019/11/11 09:51
 */
public class EnumUtil {

    private EnumUtil() {
    }

    /**
     * 通过 code 获取对应的枚举对象.
     *
     * @param <E>   实现了 BaseEnum 接口的源枚举类
     * @param clazz 源枚举类 Class 对象
     * @param code  代码
     * @return 目标枚举类
     */
    public static <E extends BaseEnum> E getEnumByCode(Class<E> clazz, Integer code) {
        for (E enumConst : clazz.getEnumConstants()) {
            if (enumConst.getCode() == code) {
                return enumConst;
            }
        }
        return null;
    }
}
