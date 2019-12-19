package com.typeng.utils.enums;

import java.util.Arrays;
import java.util.Optional;

/**
 * 枚举通用基础方法.
 * <p>K - 枚举对应的 code 的类型.</p>
 *
 * @author ty-peng
 * @since 2019/11/27 18:10
 */
public interface BaseEnum<K> {

    /**
     * 获取枚举对应的 code 值.
     *
     * @return K code
     */
    K getCode();


    /**
     * 通过 code 查找对应的枚举.
     *
     * @param enumClass 枚举class
     * @param code      code
     * @param <T>       实现了 BaseEnum 接口的枚举类型
     * @param <K>       code 的类型
     * @return 对应的 T 类型枚举
     */
    static <T extends BaseEnum<K>, K> T getEnumByCode(Class<T> enumClass, K code) {
        if (code == null) {
            return null;
        }
        final T[] enums = enumClass.getEnumConstants();
        Optional<T> enumOptional = Arrays.stream(enums).filter(baseEnum -> baseEnum.getCode().equals(code)).findAny();
        return enumOptional.orElseThrow(() -> new RuntimeException("未找到：" + code + " 对应的" + enumClass.getName()));
    }


}
