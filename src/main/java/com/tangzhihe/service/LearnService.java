package com.tangzhihe.service;

import java.util.List;
import com.tangzhihe.util.Page;
import com.tangzhihe.domain.LearnResource;
import com.tangzhihe.model.LearnResourceModel;

public interface LearnService {
	public List<LearnResource> queryLearnResouceList(Page<LearnResourceModel> page);
	
	
}
