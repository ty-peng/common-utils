package com.typeng.utils.enums;

/**
 * 测试枚举.
 *
 * @author ty-peng
 * @since 2019/11/27 18:26
 */
public enum TestEnum implements BaseEnum<Integer> {
    TEST(1);

    int code;

    TestEnum(int code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }
}
