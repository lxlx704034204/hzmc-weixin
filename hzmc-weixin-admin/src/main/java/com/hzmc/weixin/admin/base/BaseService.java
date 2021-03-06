package com.hzmc.weixin.admin.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * BaseService接口
 */
public interface BaseService<Record, Example> {

	int countByExample(Example example);

	int deleteByExample(Example example);

	int deleteByPrimaryKey(Integer id);

	int insert(Record record);

	int insertSelective(Record record);

	List<Record> selectByExampleWithBLOBs(Example example);

	List<Record> selectByExample(Example example);

	Record selectFirstByExample(Example example);

	Record selectFirstByExampleWithBLOBs(Example example);

	Record selectByPrimaryKey(Integer id);

	List<Record> selectByExampleForOffsetPage(Example example, Integer offset, Integer limit);

	int updateByExampleSelective(@Param("record") Record record, @Param("example") Example example);

	int updateByExampleWithBLOBs(@Param("record") Record record, @Param("example") Example example);

	int updateByExample(@Param("record") Record record, @Param("example") Example example);

	int updateByPrimaryKeySelective(Record record);

	int updateByPrimaryKeyWithBLOBs(Record record);

	int updateByPrimaryKey(Record record);

	int deleteByPrimaryKeys(String ids);

	void initMapper();

}