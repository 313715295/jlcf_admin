package com.admin.module.dao;


import com.admin.module.entity.User;
import com.admin.module.entity.VO.TableField;
import com.admin.module.entity.VO.TableVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by wangl on 2017/12/25.
 * todo: 数据库操作表
 */
@Repository("tableDao")
public interface TableDao extends BaseMapper<TableVO> {

    List<TableVO> listAll();

    List<TableVO> listPage(Page<TableVO> objectPage, @Param("map")Map<String, Object> map);

    Integer selectTableCount();

    Integer existTable(String tableName);

    Integer existTableField(Map<String, Object> map);

    void creatTable(Map<String, Object> map);

    void addColumn(Map<String, Object> map);

    void updateColumnSameName(Map<String, Object> map);

    void updateColumnDiffName(Map<String, Object> map);

    void dropTable(@Param("tableName") String tableName);

    void dropTableField(Map<String, Object> map);

    List<TableField> selectFields(Map<String, Object> map);

    TableVO selectDetailTable(String name);

    List<TableField> selectFields(Page<TableField> objectPage, Map<String, Object> map);

    void changeTableName(Map<String, Object> map);

    void changeTableComment(Map<String, Object> map);
}
