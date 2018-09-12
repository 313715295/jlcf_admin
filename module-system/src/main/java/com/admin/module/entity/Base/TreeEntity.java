package com.admin.module.entity.Base;


import com.admin.commons.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import java.util.List;

/**
 * 数据Entity类
 *
 * @author chenjianann
 *
 * @version 2014-05-16
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public abstract class TreeEntity<T extends BaseEntity> extends DataEntity<T> {

    private static final long serialVersionUID = 1L;

    /**
     * varchar(64) NULL父id
     */
    @TableField(value = "parent_id")
    protected Long parentId;

    /**
     * 节点层次（第一层，第二层，第三层....）
     */
    protected Integer level;
    /**
     * varchar(1000) NULL路径
     */
    @TableField(value = "parent_ids")
    protected String parentIds;
    /**
     * int(11) NULL排序
     */
    protected Integer sort;

    @TableField(exist = false)
    protected List<T> children;

    @TableField(exist = false)
    protected T parentTree;

    public TreeEntity() {
        super();
        this.sort = 30;
    }

    public TreeEntity(Long id) {
        super(id);
    }


    @Length( max = 1000, message = "路径长度必须介于 1 和 1000 之间")
    public String getParentIds() {
        return parentIds;
    }


}
