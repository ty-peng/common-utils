package com.typeng.utils.conventions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 命名规范相关的常量.
 *
 * @author ty-peng
 * @date 2020-02-20 15:07
 */
public class NamingConventionsConst {

    // ************************ 配置 ************************
    /**
     * 合格的命名后缀
     */
    public static final String[] QUALIFIED_NAMING_SUFFIX = {"Action", "Annotation", "AO", "Batis", "Bean", "BO", "Builder", "Cache",
            "Const", "Controller", "DAO", "DO", "DTO", "Enum", "Exception", "Factory", "Filter", "Handler", "Impl", "Listener", "Manager",
            "Monitor", "PO", "Proxy", "Result", "Service", "Servlet", "Test", "Util", "Utils", "View", "VO"};
    /**
     * 要扫描的文件格式
     */
    public static final String[] FILE_FORMATS = {".java"};
    /**
     * 是否展示具体类
     */
    public static boolean showClasses = true;
    /**
     * 是否启用排除合格的命名后缀白名单
     */
    public static boolean enableWhiteList = true;

    // ************************ 工具类常量 ************************
    /**
     * 合格的命名后缀集
     */
    protected static final Set<String> QUALIFIED_NAMING_SUFFIX_SET = new HashSet<>(Arrays.asList(QUALIFIED_NAMING_SUFFIX));
    /**
     * 要扫描的文件格式集
     */
    protected static final Set<String> FILE_FORMAT_SET = new HashSet<>(Arrays.asList(FILE_FORMATS));

}
