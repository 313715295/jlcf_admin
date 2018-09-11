package com.admin.module.entity.VO;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Created by tnt on 2017/12/6.
 * ${TODO}
 */
@Data
@Accessors(chain = true)
public class TreeMenu {
    private Long id;
    private  Long pid;
    private String title;
    private String icon;
    private String href;
    private Boolean spread;
    List<TreeMenu> children = Lists.newArrayList();

    public TreeMenu(Boolean spread) {
        this.spread = false;
    }

    public TreeMenu(Long id, Long pid, String title,String icon, String href) {
        this.id = id;
        this.pid = pid;
        this.title = title;
        this.icon = icon;
        this.href = href;
    }

}
