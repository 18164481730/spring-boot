package com.tangzhihe.service;

import java.util.List;
import com.tangzhihe.util.Page;
import com.tangzhihe.domain.LearnResource;
import com.tangzhihe.model.LeanQueryLeanListReq;

public interface LearnService extends IService<LearnResource>{
	public List<LearnResource> queryLearnResouceList(Page<LeanQueryLeanListReq> page);
    public void deleteBatch(Long[] ids);
}
