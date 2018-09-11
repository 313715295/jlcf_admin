package com.admin.module.entity.VO;

import com.admin.module.entity.Dict;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @Author:tnt
 * @Description:${TODO}
 * @Date: Create in 18:00 2017/12/25.
 */
@Data
@Accessors(chain = true)
public class TableField implements Serializable{
    private String name;
    private Integer length;
    private String type;
    /**
     * 字段是否可以为空
     */
    private String isNullValue;
    /**
     * 字段描述
     */
    private String comment;

    /**
     * 字段用户(输入框..select..等等)
     */
    private String dofor;

    /***
     * 表名
     */
    private String tableName;

    /***
     * 表类型
     */
    private Integer tableType;

    /***
     * 表的注释
     */
    private String tableComment;

    /***
     * 是否为系统默认选项值(switch类型的按钮用得到)
     */
    private Boolean defaultValue;

    /***
     * 多选项目内置属性
     */
    private List<Dict> dictlist;

    /**
     * 字段原名称
     */
    private String oldName;

    /**
     * 列表table里是否显示该字段
     */
    private Boolean listIsShow = true;

    /**
     * 列表上方是否根据此字段来搜索
     */
    private Boolean listIsSearch = false;

}
