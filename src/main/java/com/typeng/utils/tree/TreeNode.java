package com.typeng.utils.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 树节点.
 *
 * @author Ty Peng
 * @since 2019/9/12 10:49
 */
public class TreeNode<T extends TreeNodeConvertible> {
    private String id;
    private String text;
    private String pid;
    private Object attributes;
    private List<TreeNode<T>> nodes = new ArrayList<>();
    /**
     * 业务对象数据.
     */
    private T data;

    public TreeNode() {
    }

    public TreeNode(T entity) {
        this.id = entity.getNodeId() == null ? "" : entity.getNodeId();
        this.text = entity.getNodeName();
        this.pid = entity.getParentNodeId() == null ? "" : entity.getParentNodeId();
        this.attributes = entity.getAttributes();
        this.data = entity;
    }

    public String getId() {
        return id;
    }

    public TreeNode<T> setId(String id) {
        this.id = id;
        return this;
    }

    public String getText() {
        return text;
    }

    public TreeNode<T> setText(String text) {
        this.text = text;
        return this;
    }

    public String getPid() {
        return pid;
    }

    public TreeNode<T> setPid(String pid) {
        this.pid = pid;
        return this;
    }

    public Object getAttributes() {
        return attributes;
    }

    public TreeNode<T> setAttributes(Object attributes) {
        this.attributes = attributes;
        return this;
    }

    public List<TreeNode<T>> getNodes() {
        return nodes;
    }

    public TreeNode<T> setNodes(List<TreeNode<T>> nodes) {
        this.nodes = nodes;
        return this;
    }

    public T getData() {
        return data;
    }

    public TreeNode<T> setData(T data) {
        this.data = data;
        return this;
    }
}
