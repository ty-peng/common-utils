package com.typeng.utils.conventions;

/**
 * 命名规范检查相关信息类.
 *
 * @author ty-peng
 * @date 2020-02-20 16:03
 */
public class NamingInfo {

    /**
     * 文件名
     */
    private String fileName;
    /**
     * 类名
     */
    private String className;
    /**
     * 类后缀
     */
    private String classSuffix;
    /**
     * 路径
     */
    private String path;

    public String getFileName() {
        return fileName;
    }

    public NamingInfo setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public String getClassName() {
        return className;
    }

    public NamingInfo setClassName(String className) {
        this.className = className;
        return this;
    }

    public String getClassSuffix() {
        return classSuffix;
    }

    public NamingInfo setClassSuffix(String classSuffix) {
        this.classSuffix = classSuffix;
        return this;
    }

    public String getPath() {
        return path;
    }

    public NamingInfo setPath(String path) {
        this.path = path;
        return this;
    }

}
