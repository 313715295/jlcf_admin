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
public class Msg extends Model<Msg> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "msg_id", type = IdType.AUTO)
    private Integer msgId;

    /**
     * 消息类型 0 系统消息 1 公告中心  2官方通知 3首页公告通知
     */
    private Integer msgCode;

    /**
     * 标题
     */
    private String topic;

    /**
     * 内容
     */
    private String msg;

    /**
     * 用户id
     */
    private Integer userId;

    private String addtime;

    /**
     * 默认 0    删除 1
     */
    private Integer deleted;

    /**
     * 图片地址
     */
    private String img;


    @Override
    protected Serializable pkVal() {
        return this.msgId;
    }

}
