package com.typeng.utils.codegen;

import org.junit.jupiter.api.Test;

/**
 * Bean 属性拷贝代码生成工具测试.
 *
 * @author ty-peng
 * @date 2020-06-06 16:29
 */
class BeanCopyCodeGeneratorTest {

    @Test
    void gen() {
        BeanCopyCodeGenerator.gen(A.class, B.class);
    }

    @Test
    void listAllThisFields() {
        BeanCopyCodeGenerator.listAllThisFields(A.class);
    }

    @Test
    void listAllSetters() {
        BeanCopyCodeGenerator.listAllSetters(A.class);
    }

    @Test
    void listAllGetters() {
        BeanCopyCodeGenerator.listAllGetters(A.class);
    }

    private class A {
        private int id;

        private String str;

        private String strA;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        public String getStrA() {
            return strA;
        }

        public void setStrA(String strA) {
            this.strA = strA;
        }
    }

    private class B {
        private int id;

        private String str;

        private String strB;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        public String getStrB() {
            return strB;
        }

        public void setStrB(String strB) {
            this.strB = strB;
        }
    }
}
