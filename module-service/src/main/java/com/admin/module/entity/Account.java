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
public class Account extends Model<Account> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 红包已收收益
     */
    private BigDecimal hongbao;

    /**
     * 资金总额=后三者相加
     */
    private BigDecimal total;

    /**
     * 可用余额
     */
    private BigDecimal useMoney;

    /**
     * 提现中金额
     */
    private BigDecimal noUseMoney;

    /**
     * 待收本金+代收利息+待收红包
     */
    private BigDecimal collection;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
