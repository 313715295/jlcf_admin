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
 * 资金记录
 * </p>
 *
 * @author zwq
 * @since 2018-09-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AccountLog extends Model<AccountLog> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * tender_banlance --余额投资  tender_bank --银行卡投资  unfreeze--回款
    withdraw --提现 recharge--充值
     */
    private String type;

    /**
     * 总金额
     */
    private BigDecimal total;

    /**
     * 操作金额
     */
    private BigDecimal money;

    /**
     * 可用金额
     */
    private BigDecimal useMoney;

    /**
     * 冻结金额
     */
    private BigDecimal noUseMoney;

    /**
     * 待还款金额
     */
    private BigDecimal collection;

    /**
     * 备注
     */
    private String remark;

    private String addtime;

    private String addip;

    /**
     * 交易流水号
     */
    private String seqno;

    /**
     * 处理时间
     */
    private String duetime;

    /**
     * 状态 2新建 3已审批 1成功 -3审批拒绝 -1失败
     */
    private Integer status;

    /**
     * 手续费
     */
    private BigDecimal fee;

    /**
     * 渠道
     */
    private String channel;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
