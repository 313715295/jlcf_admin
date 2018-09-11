package com.admin.module.entity.VO;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wangl on 2017/11/28.
 * todo:
 */
@Data
@Accessors(chain = true)
public class ShowMenu implements Serializable{
    private Long id;
    private  Long pid;
    private String title;
    private String icon;
    private String href;
    private Boolean spread = false;
    private List<ShowMenu> children = Lists.newArrayList();

}
