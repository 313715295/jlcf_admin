package com.admin.module.entity;


import com.admin.module.entity.Base.DataEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * <p>
 *
 * </p>
 *
 * @author wangl
 * @since 2017-12-30
 */
@TableName("sys_site")
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class Site extends DataEntity<Site> {

	private static final long serialVersionUID = 1L;

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
	 * 数据库类型和版本号
	 */
	private String IDatabase;
    /**
     * 关键字
     */
    private String keywords;
    /**
     * 网站描述
     */
    private String description;
    /**
     * 网站版权信息
     */
    private String powerby;
    /**
     * 网站备案号
     */
    private String record;
    /**
     * ICP许可证号
     */
    @TableField(value = "ICP_info")
    private String ICPInfo;
    /**
     * 公安机关备案号
     */
    private String agencyRecord;
}
