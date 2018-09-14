package com.admin.module.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 红包日志
 * </p>
 *
 * @author zwq
 * @since 2018-09-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class HongbaoLog extends Model<HongbaoLog> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private BigDecimal hongbaoMoney;

    private String remark;

    private String addtime;

    /**
     * 红包id
     */
    private Integer activeId;

    private String addip;

    /**
     * 0元币够买。1.元币充值。2赠送红包。3.使用红包
     */
    private Integer status;

    /**
     * 用户可用元币
     */
    @TableField("userTotal")
    private String userTotal;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
