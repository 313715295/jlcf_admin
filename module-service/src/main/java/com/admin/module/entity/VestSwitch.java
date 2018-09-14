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
public class VestSwitch extends Model<VestSwitch> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 渠道
     */
    private String channel;

    /**
     * 版本号
     */
    private String version;

    /**
     * 状态 0马甲关闭，1马甲开启
     */
    private Integer status;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
