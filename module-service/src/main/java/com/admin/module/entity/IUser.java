package com.admin.module.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("user")
public class IUser extends Model<IUser> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    /**
     * 用户权限 default 2：普通用户 3：借款用户    10000-红包账户  10001-手续费账户
     */
    private Integer typeId;

    private Integer order;

    private String purview;

    /**
     * 用户名--default 手机号
     */
    private String username;

    /**
     * 真实姓名
     */
    private String username2;

    /**
     * 身份证号
     */
    private String idcard;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 支付密码
     */
    private String paypassword;

    private Integer islock;

    /**
     * 邀请好友 的 用户id
     */
    private String inviteUserid;

    /**
     * 邀请注册提成
     */
    private String inviteMoney;

    /**
     * 实名认证状态
     */
    private String realStatus;

    /**
     * 身份证 或 营业执照
     */
    private String cardType;

    private String cardId;

    private String cardPic1;

    private String cardPic2;

    private String nation;

    /**
     * 企业名称
     */
    private String realname;

    private String integral;

    private Integer status;

    private Integer avatarStatus;

    private String emailStatus;

    private String phoneStatus;

    /**
     * 视频认证
     */
    private Integer videoStatus;

    /**
     * 现场认证
     */
    private Integer sceneStatus;

    private String email;

    private String sex;

    /**
     * 头像
     */
    private String litpic;

    private String tel;

    /**
     * 注册的手机号 
     */
    private String phone;

    private String qq;

    private String wangwang;

    private String question;

    private String answer;

    private String birthday;

    private String province;

    private String city;

    private String area;

    /**
     * 详细 地址：企业注册地址
     */
    private String address;

    /**
     * 提醒设置
     */
    private String remind;

    /**
     * 法人信息
     */
    private String privacy;

    /**
     * 登录时间
     */
    private Integer logintime;

    /**
     * 注册时间
     */
    private String addtime;

    /**
     * 注册ip
     */
    private String addip;

    /**
     * 企业成立时间
     */
    private String uptime;

    private String upip;

    /**
     * 最后一次登录的时间
     */
    private String lasttime;

    private String lastip;

    private Integer isPhone;

    /**
     * 风险等级评测
     */
    @TableField("memberLevel")
    private Integer memberLevel;

    private String serialId;

    private String serialStatus;

    private String hongbao;

    /**
     * 汇付
     */
    @TableField("trust_trxId")
    private String trustTrxid;

    /**
     * 汇付
     */
    @TableField("trust_usrId")
    private String trustUsrid;

    /**
     * 汇付
     */
    @TableField("trust_UsrCustId")
    private String trustUsrcustid;

    /**
     * 用户星级
     */
    private Integer userLevel;

    /**
     * 汇付企业用户开户状态
     */
    @TableField("audit_Stat")
    private String auditStat;

    private String provinceName;

    private Integer age;

    private String sx;

    private String xz;

    /**
     * 设备  0-未知  1-Android 2-IOS 3-微信 4-电脑  
     */
    private Integer isDevice;

    /**
     * 支付渠道
     */
    private String payChannel;

    /**
     * 注册渠道
     */
    private String regChannel;

    /**
     * 注册渠道2
     */
    private String regChannel2;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
