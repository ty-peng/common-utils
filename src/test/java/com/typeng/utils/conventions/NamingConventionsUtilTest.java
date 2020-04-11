package com.typeng.utils.conventions;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.typeng.utils.conventions.NamingConventionsUtil.check;


/**
 * 命名规范工具测试类.
 *
 * @author ty-peng
 * @date 2020-02-20 14:49
 */
class NamingConventionsUtilTest {

    @Test
    void testCheck() throws IOException {
        Path path = Paths.get("D:", "projects", "xxx");
        check(path);
    }
}