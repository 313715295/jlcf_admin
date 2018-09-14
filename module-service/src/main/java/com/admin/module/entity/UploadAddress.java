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
 * 积分兑换人地址（一桶金积分商城新增）
 * </p>
 *
 * @author zwq
 * @since 2018-09-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UploadAddress extends Model<UploadAddress> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 收货人
     */
    @TableField("toUser_name")
    private String touserName;

    /**
     * 地址
     */
    private String adress;

    /**
     * 详细地址
     */
    private String adressDeatil;

    /**
     * 邮编
     */
    private String post;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 用户地址状态 0-其他地址 1-默认地址
     */
    private Integer status;

    /**
     * 省份
     */
    private String shengfen;

    /**
     * 城市
     */
    private String city;

    /**
     * 新增时间
     */
    private LocalDateTime addtime;

    /**
     * 备注
     */
    private String remark;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
