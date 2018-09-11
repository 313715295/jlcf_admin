package com.admin.module.entity.VO;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * Ztree 树
 * @author Administrator
 *
 */
@Data
@Accessors(chain = true)
public class ZtreeVO implements Serializable{

	private Long id;

	private Long pid;

	private String name;
	
	private String url;
	
	private Boolean open =true;
	
	private Boolean isParent;
	
	private String icon;
	
	private List<ZtreeVO> children;


}
