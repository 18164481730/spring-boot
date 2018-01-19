package com.tangzhihe.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.tangzhihe.domain.LearnResource;
import com.tangzhihe.model.LearnResourceModel;

public interface LearnResourceDao {
	/**
	 * 查询全部数据
	 * @param map
	 * @return
	 */
	public List<LearnResource> queryLearnResouceList(@Param("entity") LearnResourceModel model);
	
	/**
	 * 删除数据
	 * @param userId
	 * @return
	 */
	public int deleteByLearnResource(Long id);
	
	/**
	 * 插入数据
	 * @param learnResource
	 * @return
	 */
	public int insertByLearnResource(@Param("entity") LearnResource learnResource);
	
	/**
	 * 更新数据
	 * @param learnResource
	 * @return
	 */
	public int updateByLearnResource(@Param("entity") LearnResource learnResource);
}























