package com.typeng.utils.tree;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 树模型工具类.
 *
 * @author Ty Peng
 * @since 2019/9/12 09:37
 */
public class TreeNodeUtil {

    private TreeNodeUtil() {
    }

    /**
     * 列表转树形结构的实现方式（迭代或递归）.
     */
    public enum MethodType {
        /**
         * 迭代.
         */
        ITERATION,
        /**
         * 递归.
         */
        RECURSIVE
    }

    /**
     * 列表转化为树形结构（默认使用迭代方式实现）.
     *
     * @param entities 实体列表
     * @return 树形结构列表
     * @author Ty Peng
     * @since 2019-09-12 11:11
     */
    public static <T extends TreeNodeConvertible> List<TreeNode<T>> list2Tree(List<T> entities, MethodType methodType) {
        switch (methodType) {
            case RECURSIVE:
                return list2TreeByRecursive(entities);
            case ITERATION:
            default:
                return list2Tree(entities);
        }
    }

    /**
     * 列表转化为树形结构（迭代循环方式）.
     *
     * @param entities 实体列表
     * @return 树形结构列表
     * @author Ty Peng
     * @since 2019-09-12 15:37
     */
    public static <T extends TreeNodeConvertible> List<TreeNode<T>> list2Tree(List<T> entities) {
        List<TreeNode<T>> nodeList = convert2NodeList(entities);
        List<TreeNode<T>> treeList = new ArrayList<>();
        // 获取所有节点ID
        List<String> allId = new ArrayList<>();
        for (TreeNode<T> node : nodeList) {
            if (!allId.contains(node.getId())) {
                allId.add(node.getId());
            }
        }
        for (TreeNode<T> node : nodeList) {
            // 顶层节点，父节点不存在于当前所有节点ID列表时，也视作顶层节点
            if (StringUtils.isBlank(node.getPid()) || !allId.contains(node.getPid())) {
                treeList.add(node);
            }
            for (TreeNode<T> child : nodeList) {
                // 遍历添加当前 node 的所有子节点
                if (node.getId().equals(child.getPid())) {
                    node.getNodes().add(child);
                }
            }
        }
        return treeList;
    }

    /**
     * 业务对象列表转换到树节点对象列表.
     *
     * @param entities 业务实体列表
     * @return 树节点对象列表
     */
    private static <T extends TreeNodeConvertible> List<TreeNode<T>> convert2NodeList(List<T> entities) {
        List<TreeNode<T>> nodeList = new ArrayList<>();
        // 用业务对象构造树节点对象
        for (T t : entities) {
            TreeNode<T> node = new TreeNode<>(t);
            nodeList.add(node);
        }
        return nodeList;
    }

    /**
     * 列表转化为树形结构（递归方式）.
     *
     * @param entities 实体列表
     * @return 树形结构列表
     * @author Ty Peng
     * @since 2019-09-12 15:37
     */
    private static <T extends TreeNodeConvertible> List<TreeNode<T>> list2TreeByRecursive(List<T> entities) {
        List<TreeNode<T>> nodeList = convert2NodeList(entities);
        List<TreeNode<T>> treeList = new ArrayList<>();
        for (TreeNode<T> node : nodeList) {
            if (StringUtils.isBlank(node.getPid())) {
                treeList.add(findChildren(node, nodeList));
            }
        }
        return treeList;
    }

    /**
     * 递归查找子节点.
     *
     * @param parent   当前节点
     * @param nodeList 实体列表
     * @return 获取 children 后的节点
     * @author Ty Peng
     * @since 2019-09-12 16:04
     */
    private static <T extends TreeNodeConvertible> TreeNode<T> findChildren(TreeNode<T> parent, List<TreeNode<T>> nodeList) {
        for (TreeNode<T> child : nodeList) {
            if (parent.getId().equals(child.getPid())) {
                parent.getNodes().add(findChildren(child, nodeList));
            }
        }
        return parent;
    }

}
