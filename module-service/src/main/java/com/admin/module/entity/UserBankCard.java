package com.admin.module.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
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
public class UserBankCard extends Model<UserBankCard> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String bankCard;

    private Integer userId;

    private String pid;

    @TableField("bank_Name")
    private String bankName;

    private String status;

    private String gmtCreate;

    private LocalDateTime gmtWrite;

    /**
     * 银行机构号
     */
    private String inscd;

    /**
     * 协议号
     */
    private String protocolno;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 银行log图片url
     */
    private String bankLog;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
