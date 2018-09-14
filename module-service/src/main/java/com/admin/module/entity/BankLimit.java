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
public class BankLimit extends Model<BankLimit> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 银行名称
     */
    private String bankName;

    /**
     * 银行机构号
     */
    private String inscd;

    /**
     * 单笔限额
     */
    private Integer perLimit;

    /**
     * 每日限额
     */
    private Integer dailyLimit;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
