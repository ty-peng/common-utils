package com.typeng.utils.tree;

import java.util.Map;

/**
 * 树节点转化接口.
 *
 * @author Ty Peng
 * @since 2019/9/11 14:41
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
     * 根节点 parentId 为 null 时注意空指针异常.
     * @return 父节点ID
     */
    String getParentNodeId();

    /**
     * @return 节点所属部门ID
     */
    Integer getNodeDeptId();

    /**
     * @return 获取源系统
     */
    Integer getNodeSystemId();

    /**
     * @return 获取排序位数权重.
     */
    Integer getOrders();

    /**
     * @return 其他属性
     */
    Map<String, Object> getAttributes();

}
