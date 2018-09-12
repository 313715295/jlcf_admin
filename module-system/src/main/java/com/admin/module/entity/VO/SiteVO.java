package com.admin.module.entity.VO;

import com.admin.commons.utils.NumberUtil;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Properties;

@Data
@Accessors(chain = true)
public class SiteVO {
    /**
     * id
     */
    private Long id;

    /**
     * 网站名称
     */
    private String name;
    /**
     * 当前版本
     */
    private String version;
    /**
     * 官方网站网址
     */
    private String url;
    /**
     * 客服热线
     */
    private String phone;
    /**
     * 官微
     */
    private String weibo;
    /**
     * 客服QQ群号
     */
    private String qq;
    /**
     * 客服邮箱
     */
    private String email;
    /**
     * 公司地址
     */
    private String address;
    /**
     * logo
     */
    private String logo;
    /**
     * 网站备案号
     */
    private String record;
    /**
     * 数据库类型和版本号
     */
    private String IDatabase;

    //系统信息
    /**
     * 服务器操作系统信息
     */
    private String server;
    /**
     * java运行环境
     */
    private String javaRunEnvironment;
    /**
     * java虚拟机
     */
    private String javaVM;
    /**
     * 系统账户
     */
    private String systemUser;
    /**
     * 已用内存
     */
    private String usedMemory;
    /**
     * 可用内存
     */
    private String useAbleMemory;
    /**
     * 最大内存
     */
    private String maxMemory;
    /**
     * 目录
     */
    private String dir;
    /**
     * 临时目录
     */
    private String tmpdir;

    {
        Properties props = System.getProperties();
        Runtime runtime = Runtime.getRuntime();
        double freeMemory = runtime.freeMemory();
        double totalMemory = runtime.totalMemory();
        double usedMemory = totalMemory - freeMemory;
        double maxMemory = runtime.maxMemory();
        double useAbleMemory = maxMemory - totalMemory + freeMemory;
        this.setServer(props.getProperty("os.name") + ":" + props.getProperty("os.version"))
                .setJavaRunEnvironment(props.getProperty("java.runtime.name") + ":" + props.getProperty("java.runtime.version"))
                .setJavaVM(props.getProperty("java.vm.name") + ":" + props.getProperty("java.vm.version"))
                .setSystemUser(props.getProperty("user.name"))
                .setUsedMemory(NumberUtil.strFormat2Round(usedMemory / 1024 / 1024))
                .setUseAbleMemory(NumberUtil.strFormat2Round(useAbleMemory / 1024 / 1024))
                .setMaxMemory(NumberUtil.strFormat2Round(maxMemory / 1024 / 1024))
                .setDir(props.getProperty("user.dir"))
                .setTmpdir(props.getProperty("java.io.tmpdir"));
    }


}
