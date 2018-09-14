package com.admin.module.entity;

import java.math.BigDecimal;
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
public class NewhbType extends Model<NewhbType> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "hbleixingid", type = IdType.AUTO)
    private Integer hbleixingid;

    /**
     * 红包名称(标题)
     */
    private String hbname;

    /**
     * 红包类型（比如：0平台注册时赠送，1。完成实名认证赠送等等）
     */
    private Integer hbtype;

    /**
     * 描述红包规则
     */
    private String hbdetail;

    /**
     * 红包，加息券有效天数
     */
    private BigDecimal hbmoney;

    /**
     * 红包使用金额限制
     */
    private Integer smoney;

    /**
     * 红包使用投资周期限制
     */
    private Integer sday;

    /**
     * 红包，加息券有效天数
     */
    private Integer yday;


    @Override
    protected Serializable pkVal() {
        return this.hbleixingid;
    }

}
