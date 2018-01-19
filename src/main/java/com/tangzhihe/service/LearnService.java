package com.tangzhihe.service;

import java.util.List;
import com.tangzhihe.domain.LearnResource;
import com.tangzhihe.model.LearnResourceModel;
import com.tangzhihe.util.Page;

public interface LearnService {
	public List<LearnResource> queryLearnResouceList(Page<LearnResourceModel> page);
	
	public int save(LearnResource learnResource);
	
	public int update(LearnResource learnResource);
	
	public void delete(Long[] ids);
}
