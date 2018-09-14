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
public class ImagesType extends Model<ImagesType> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 标题
     */
    private String name;

    /**
     * 类型 1--app首页  2--活动中心  3--PC首页 4--运营报告 5--金豆商城首页 
     */
    private Integer type;

    /**
     * 状态 0--隐藏 1--显示
     */
    private Integer status;

    /**
     * 点击跳转url
     */
    private String jumurl;

    /**
     * 图片地址
     */
    private String imgurl;

    /**
     * 分享内容
     */
    private String scontent;

    /**
     * 分享地址
     */
    private String surl;

    /**
     * 分享标题
     */
    private String stitle;

    /**
     * 分享小图片地址
     */
    private String simgurl;

    /**
     * 排序
     */
    private Integer torder;

    /**
     * 开始时间
     */
    private String stime;

    /**
     * 结束时间
     */
    private String etime;

    /**
     * 新增时间
     */
    private String addtime;

    /**
     * 新增ip
     */
    private String addip;

    /**
     * 备注
     */
    private String remark;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
