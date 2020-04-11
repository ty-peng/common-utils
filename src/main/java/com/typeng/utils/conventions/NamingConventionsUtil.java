package com.typeng.utils.conventions;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.typeng.utils.conventions.NamingConventionsConst.FILE_FORMAT_SET;
import static com.typeng.utils.conventions.NamingConventionsConst.QUALIFIED_NAMING_SUFFIX_SET;
import static com.typeng.utils.conventions.NamingConventionsConst.enableWhiteList;
import static com.typeng.utils.conventions.NamingConventionsConst.showClasses;

/**
 * 命名规范工具类.
 *
 * @author ty-peng
 * @date 2020-02-20 14:39
 */
public class NamingConventionsUtil {

    /**
     * 执行指定路径下的Java命名规范检查.
     *
     * @param path 路径
     * @author ty-peng
     * @date 2020-02-20 15:06
     */
    public static void check(Path path) throws IOException {
        Map<String, List<NamingInfo>> result = traversalWithNio(path);
        List<Map.Entry<String, List<NamingInfo>>> list =
            result.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList());
        System.out.println("共" + list.size() + "个后缀：");
        list.forEach(entry -> {
            System.out.println(entry.getKey() + "(" + entry.getValue().size() + ")");
            if (showClasses) {
                entry.getValue().forEach(namingInfo -> System.out.println(namingInfo.getFileName()));
            }
            System.out.println();
        });
    }

    /**
     * 使用NIO工具类遍历文件夹所有文件获取所有命名后缀（除合格命名后缀外）相关的信息.
     *
     * @param path 待遍历文件夹路径
     * @return 命名后缀相关信息
     * @author ty-peng
     * @date 2020-02-20 14:53
     */
    public static Map<String, List<NamingInfo>> traversalWithNio(Path path) throws IOException {
        Map<String, List<NamingInfo>> suffixInfos = new HashMap<>(200);
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path filePath, BasicFileAttributes attrs) {
                if (!attrs.isDirectory()) {
                    File file = filePath.toFile();
                    String classSuffix = getClassSuffix(file);
                    if (classSuffix != null) {
                        if (enableWhiteList && QUALIFIED_NAMING_SUFFIX_SET.contains(classSuffix)) {
                            return FileVisitResult.CONTINUE;
                        }
                        NamingInfo info = new NamingInfo().setFileName(file.getName()).setClassSuffix(classSuffix)
                            .setPath(file.getAbsolutePath());
                        if (!suffixInfos.containsKey(classSuffix)) {
                            suffixInfos.put(classSuffix, new ArrayList<>());

                        }
                        suffixInfos.get(classSuffix).add(info);
                    }
                }
                return FileVisitResult.CONTINUE;
            }
        });
        return suffixInfos;
    }

    /**
     * 使用Guava工具类遍历文件夹所有文件获取所有后缀信息.
     *
     * @param path      待遍历文件夹路径
     * @param suffixSet 后缀结果集
     * @author ty-peng
     * @date 2020-02-20 14:53
     */
    @Deprecated
    public static void traversalWithGuava(Path path, Set<String> suffixSet) {
        // Guava （比使用NIO慢）
        com.google.common.io.Files.fileTraverser().breadthFirst(path.toFile()).forEach(file -> {
            String classSuffix = getClassSuffix(file);
            if (classSuffix != null) {
                suffixSet.add(classSuffix);
            }
        });
    }

    /**
     * 获取Java类文件的类名后缀.
     *
     * @param file Java源文件
     * @return String
     * @author ty-peng
     * @date 2020-02-20 15:00
     */
    public static String getClassSuffix(File file) {
        if (file == null) {
            return null;
        }
        String fileName = file.getName();
        int dotIndex = fileName.lastIndexOf(".");
        // 没有文件格式后缀或非指定文件格式后缀
        if (dotIndex < 0 || !FILE_FORMAT_SET.contains(fileName.substring(dotIndex))) {
            return null;
        }
        return getClassSuffix(fileName.substring(0, dotIndex));
    }

    /**
     * 获取Java类名后缀.
     *
     * @param className Java类名
     * @return String
     * @author ty-peng
     * @date 2020-02-20 15:00
     */
    public static String getClassSuffix(String className) {
        String result;
        StringBuilder suffixBuilder = new StringBuilder();
        // 从后往前遍历
        char[] chars = className.toCharArray();
        boolean endWithUppercase = isUppercase(chars[chars.length - 1]);
        for (int i = chars.length - 1; i >= 0; i--) {
            suffixBuilder.append(chars[i]);
            if (isUppercase(chars[i])) {
                // 如果不是全大写后缀，直接跳出循环获取结果
                if (i <= 0 || !endWithUppercase || !isUppercase(chars[i - 1])) {
                    break;
                }
            }
        }
        result = suffixBuilder.reverse().toString();
        return result;
    }

    /**
     * 判断字符是否是大写字母.
     *
     * @param c 字符
     * @return boolean
     * @author ty-peng
     * @date 2020-02-19 16:33
     */
    private static boolean isUppercase(char c) {
        return c >= 'A' && c <= 'Z';
    }
}
