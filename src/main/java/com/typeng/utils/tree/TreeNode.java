package com.typeng.utils.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 树节点.
 *
 * @author ty-peng
 * @since 2019-11-09 17:21
 */
public class TreeNode<T extends TreeNodeConvertible> {
    private String id;
    private String name;
    private String pid;
    private Object data;
    private List<TreeNode<T>> nodes = new ArrayList<>();

    public TreeNode() {
    }

    public TreeNode(T entity) {
        this.id = entity.getNodeId() == null ? "" : entity.getNodeId();
        this.name = entity.getNodeName();
        this.pid = entity.getParentNodeId() == null ? "" : entity.getParentNodeId();
        this.data = entity.getData();
    }

    public String getId() {
        return id;
    }

    public TreeNode<T> setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TreeNode<T> setName(String name) {
        this.name = name;
        return this;
    }

    public String getPid() {
        return pid;
    }

    public TreeNode<T> setPid(String pid) {
        this.pid = pid;
        return this;
    }

    public Object getData() {
        return data;
    }

    public TreeNode<T> setData(Object data) {
        this.data = data;
        return this;
    }

    public List<TreeNode<T>> getNodes() {
        return nodes;
    }

    public TreeNode<T> setNodes(List<TreeNode<T>> nodes) {
        this.nodes = nodes;
        return this;
    }

}
