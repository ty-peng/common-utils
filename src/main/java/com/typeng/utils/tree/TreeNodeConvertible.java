package com.typeng.utils.tree;


/**
 * 树节点转化接口.
 *
 * @author ty-peng
 * @since 2019-11-09 14:09
 */
public interface TreeNodeConvertible {
    /**
     * @return 节点ID
     */
    String getNodeId();

    /**
     * @return 节点名称
     */
    String getNodeName();

    /**
     * 获取父节点ID.
     * <p>ps: 根节点 parentId 为 null 时注意空指针异常.</p>
     *
     * @return 父节点ID
     */
    String getParentNodeId();

    /**
     * @return 其他属性
     */
    Object getData();

}
