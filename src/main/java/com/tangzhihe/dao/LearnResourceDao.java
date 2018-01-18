package com.tangzhihe.dao;

import java.util.Map;
import java.util.List;
import com.tangzhihe.util.MyMapper;
import com.tangzhihe.domain.LearnResource;

public interface LearnResourceDao extends MyMapper<LearnResource>{
	List<LearnResource> queryLearnResouceList(Map<String,Object> map);
}
