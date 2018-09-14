package com.admin.module.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zwq
 * @since 2018-09-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Linkage extends Model<Linkage> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 排序
     */
    private Integer order;

    /**
     * 类型
     */
    private Integer typeId;

    /**
     * 所属联动
     */
    private Integer pid;

    /**
     * 联动名称
     */
    private String name;

    /**
     * 联动的值
     */
    private String value;

    private String addtime;

    private String addip;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
