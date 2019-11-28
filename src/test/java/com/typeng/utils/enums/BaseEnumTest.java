package com.typeng.utils.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 通用枚举工具测试.
 *
 * @author ty-peng
 * @since 2019/11/27 18:23
 */
public class BaseEnumTest {

    @Test
    void getEnumByCode() {
        Assertions.assertEquals(TestEnum.TEST, BaseEnum.getEnumByCode(TestEnum.class, 1));
        Assertions.assertThrows(RuntimeException.class, () -> BaseEnum.getEnumByCode(TestEnum.class, 0));
    }
}
