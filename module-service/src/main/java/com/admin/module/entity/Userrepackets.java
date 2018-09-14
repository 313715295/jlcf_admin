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
public class Userrepackets extends Model<Userrepackets> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "hbid", type = IdType.AUTO)
    private Integer hbid;

    /**
     * 用户id
     */
    private Integer userid;

    /**
     * 红包类型id
     */
    private Integer hbleixingid;

    private String hbstartime;

    private String hbendtime;

    /**
     * 红包是否使用过（0，红包未使用，1.红包以兑现，2.红包以过期状态为 3 已使用，可能用不上）
     */
    private Integer hbstatus;

    /**
     * 邀请人id
     */
    private Integer inviter;

    /**
     * 0--未发送，1--已发送 判断是否已发送消息队列
     */
    private Integer flag;


    @Override
    protected Serializable pkVal() {
        return this.hbid;
    }

}
