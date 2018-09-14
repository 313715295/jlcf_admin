package com.admin.module.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
public class FinanceBid extends Model<FinanceBid> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String orderSn;

    /**
     * 5-银行卡投资 6-余额投资
     */
    private String type;

    private Integer borrowId;

    private Integer userId;

    /**
     * 1 是有效的
     */
    private Boolean pay;

    private String payChannel;

    private LocalDateTime payTime;

    private String channel;

    /**
     * 本金
     */
    private BigDecimal buyAmt;

    /**
     * 基础利率+标加息利率+购买成功后加上加息券利率
     */
    private BigDecimal rate;

    /**
     * 利息
     */
    private BigDecimal withdrawProfit;

    /**
     * 本金
     */
    private BigDecimal withdrawPrincipal;

    private BigDecimal couponRate;

    private BigDecimal couponAmt;

    private String payName;

    private String payPid;

    private String bankCardNo;

    private String bankNo;

    private String bankName;

    private String beginProfit;

    private String endProfit;

    private LocalDateTime gmtWithdraw;

    private String summary;

    /**
     * repayment 还款 counting在投
     */
    private String status;

    private String gmtCreate;

    private LocalDateTime gmtWrite;

    /**
     * 还款时间
     */
    private LocalDateTime repayTime;

    /**
     * 投标渠道
     */
    private String regChannel;

    /**
     * 福利劵id
     */
    private String hbid;

    /**
     * 云合同的合同id
     */
    private String contractId;

    /**
     * 即信返回信息登记
     */
    private String remark;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
