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
 * 
 * </p>
 *
 * @author zwq
 * @since 2018-09-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Borrow extends Model<Borrow> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 所属站点
     */
    private Integer siteId;

    /**
     * 借款人用户id
     */
    private Long userId;
    /**
     * 借款人用户名称
     */
    @TableField(exist = false)
    private String userName;
    /**
     * 标题
     */
    private String name;

    /**
     * 状态 0 等待审核，1 已上标，2 审核失败，3 审核通过，5 已满标， 8已还款
     */
    private Integer status;

    /**
     * 排序
     */
    private Integer order;

    /**
     * 点击次数
     */
    private Integer hits;

    /**
     * 标的标签
     */
    private String litpic;

    /**
     * 属性
     */
    private String flag;

    private Integer isVouch;

    private String type;

    /**
     * 标的详情显示问题0-显示老的 名门望族 1-显示新的 天府名檀
     */
    private Integer viewType;

    private String vouchAward;

    private String vouchUser;

    private String vouchAccount;

    private Integer vouchTimes;

    /**
     * 来源
     */
    private String source;

    /**
     * 发布时间
     */
    private String publish;

    /**
     * 客服
     */
    private String customer;

    private String numberId;

    /**
     * 审核人
     */
    private String verifyUser;

    /**
     * 客服
     */
    private String verifyTime;

    private String verifyRemark;

    private Integer repaymentUser;

    private String forstAccount;

    /**
     * 实际还款本金金额
     */
    private String repaymentAccount;

    /**
     * 每月还款额（记录批次号第几次请求）
     */
    private String monthlyRepayment;

    /**
     * 实际还款本息金额
     */
    private String repaymentYesaccount;

    /**
     * 还款成功次数
     */
    private Integer repaymentYesinterest;

    /**
     * 批次还款请求提交的时间
     */
    private String repaymentTime;

    private String repaymentRemark;

    /**
     * 放款时间
     */
    private String successTime;

    /**
     * 预期还款时间
     */
    private String endTime;

    private String paymentAccount;

    /**
     * 银行存管起息时间
     */
    private String eachTime;

    /**
     * 用途 0  新手
     */
    private String use;

    /**
     * 借款期限
     */
    private String timeLimit;

    /**
     * 还款方式
     */
    private String style;

    /**
     * 借贷总金额
     */
    private String account;

    /**
     * 已购买金额
     */
    private BigDecimal accountYes;

    private String tenderTimes;

    /**
     * 年利率
     */
    private BigDecimal apr;

    /**
     * 最低投标金额
     */
    private String lowestAccount;

    /**
     * 最多投标总额
     */
    private String mostAccount;

    /**
     * 有效时间
     */
    private String validTime;

    /**
     * 投标奖励
     */
    private BigDecimal award;

    /**
     * 失败交易金额 (分摊奖励金额)
     */
    private BigDecimal partAccount;

    /**
     * 比例奖励的比例
     */
    private BigDecimal funds;

    /**
     * 标的失败时也同样奖励 
     */
    private String isFalse;

    /**
     * (成功放款金额) 公开我的帐户资金情况
     */
    private String openAccount;

    /**
     * 公开我的借款资金情况
     */
    private String openBorrow;

    /**
     * 公开我的投标资金情况
     */
    private String openTender;

    /**
     * 公开我的信用额度情况
     */
    private String openCredit;

    /**
     * 详细说明
     */
    private String content;

    /**
     * 担保机构
     */
    private String content2;

    /**
     * 担保机构名
     */
    private String guarantee;

    /**
     * 物业宝/学费宝页面说明
     */
    private String contentUse56;

    private String addtime;

    private String addip;
    /**
     * 标的风险等级
     */
    private Integer isMb;

    private Integer isFast;

    private Integer isJin;

    private Integer isXin;

    private String pwd;

    private Integer isday;

    /**
     * 投标期限
     */
    private Integer timeLimitDay;

    private Integer isArt;

    private Integer isCharity;

    private Integer isProject;

    /**
     * 流转标的标识字段
     */
    private Integer isFlow;

    /**
     * 流转标的状态
     */
    private Integer flowStatus;

    /**
     * 失败交易金额(流转标)
     */
    private Integer flowMoney;

    /**
     * 失败交易笔数 (流转标的总份数)
     */
    private Integer flowCount;

    /**
     * 成功放款笔数 （流转标已经购买的份数）
     */
    private Integer flowYescount;

    /**
     * 学信标字段
     */
    private Integer isStudent;

    private Integer isOffvouch;

    /**
     * 认证等级
     */
    private Integer trustLevel;

    private String borrowFeeApr;

    private BigDecimal borrowFee;

    /**
     * 标的收益种类
     */
    @TableField("borrowTypes")
    private Integer borrowTypes;

    /**
     * 新增：红包活动(还款成功奖励红包，标记该标是否奖励)
     */
    private Integer hongbaoTrans;

    private Integer hbFlag;

    /**
     * 是否可以使用加息卷 0-不能使用1-可以使用
     */
    private Integer jxFlag;

    /**
     * 加息部分总利息
     */
    private BigDecimal jxInterst;

    /**
     * 加息卷(0不能使用加息卷,1可以使用加息卷)
     */
    private Integer jxjFlag;

    /**
     * 加息年利率
     */
    private BigDecimal addApr;

    /**
     * 标发布种类 10--汇付 20--富友 30--江西银行
     */
    private Integer releaseType;

    /**
     * 虚拟金额
     */
    private String ficAccount;

    /**
     * 分组
     */
    private String borrowGroup;

    /**
     * 融资企业
     */
    private String financeCompany;

    /**
     * 借款用途
     */
    private String loanUsage;

    /**
     * 还款来源
     */
    private String payment;

    /**
     * 图片1
     */
    private String imgurl1;

    /**
     * 图片2
     */
    private String imgurl2;

    /**
     * 图片3
     */
    private String imgurl3;

    /**
     * 图片4
     */
    private String imgurl4;

    /**
     * 图片5
     */
    private String imgurl5;

    /**
     * 图片6
     */
    private String imgurl6;

    /**
     * 图片7
     */
    private String imgurl7;

    /**
     * 图片8
     */
    private String imgurl8;

    /**
     * 图片9
     */
    private String imgurl9;

    /**
     * 图片10
     */
    private String imgurl10;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
