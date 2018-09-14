package com.admin.module.entity;

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
public class TTimerScheduling extends Model<TTimerScheduling> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 定时任务名称
     */
    private String timerSchedulerName;

    /**
     * 定时任务uuid
     */
    private String uuid;

    /**
     * 定时任务 时间表达式(eg: * * * * * ?)
     */
    private String timerSchedulerCron;

    /**
     * 定时任务参数(json格式)
     */
    private String timerSchedulerParam;

    /**
     * 定时任务类型 1红包 ...更多待补充
     */
    private Integer timerSchedulerType;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除 true是 false不是
     */
    private Boolean deleted;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
