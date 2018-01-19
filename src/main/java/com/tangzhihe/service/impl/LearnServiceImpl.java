package com.tangzhihe.service.impl;

import java.util.Arrays;
import java.util.List;
import com.github.pagehelper.PageHelper;
import com.tangzhihe.dao.LearnResourceDao;
import com.tangzhihe.domain.LearnResource;
import com.tangzhihe.model.LearnResourceModel;
import com.tangzhihe.service.LearnService;
import com.tangzhihe.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * Created by tengj on 2017/4/7.
 */
@Service
public class LearnServiceImpl implements LearnService {

    @Autowired
    private LearnResourceDao  learnResourceDao;

    @Override
    public List<LearnResource> queryLearnResouceList(Page<LearnResourceModel> page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        LearnResourceModel learnResourceModel = new LearnResourceModel();
        return learnResourceDao.queryLearnResouceList(learnResourceModel);
    }

	@Override
	public int save(LearnResource learnResource) {
		return learnResourceDao.insertByLearnResource(learnResource);
	}

	@Override
	public int update(LearnResource learnResource) {
		return learnResourceDao.updateByLearnResource(learnResource);
	}

	@Override
	public void delete(Long[] ids) {
		 Arrays.stream(ids).forEach(id->learnResourceDao.deleteByLearnResource(id));
	}
}
