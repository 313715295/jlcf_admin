package com.admin.module.entity.Base;

import com.admin.commons.base.BaseDataEntity;
import com.admin.commons.base.BaseEntity;
import com.admin.module.entity.User;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 数据Entity类
 *
 * @param <T>
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public abstract class DataEntity<T extends BaseEntity> extends BaseDataEntity<T> {

    private static final long serialVersionUID = 1L;

    /**
     * 创建着
     */
    @TableField(exist = false)
    protected User createUser;

    /**
     * 修改者
     */
    @TableField(exist = false)
    protected User updateUser;

    public DataEntity() {
    }

    public DataEntity(Long id) {
        super(id);
    }
}
