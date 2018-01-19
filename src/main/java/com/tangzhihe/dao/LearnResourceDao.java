package com.tangzhihe.dao;

import java.util.List;
import java.util.Map;
import com.tangzhihe.domain.LearnResource;

public interface LearnResourceDao {
	List<LearnResource> queryLearnResouceList(Map<String,Object> map);
}
