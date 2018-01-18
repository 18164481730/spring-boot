package com.tangzhihe.service.impl;

import java.util.List;
import java.util.Arrays;
import com.tangzhihe.util.Page;
import com.github.pagehelper.PageHelper;
import com.tangzhihe.dao.LearnResourceDao;
import com.tangzhihe.domain.LearnResource;
import com.tangzhihe.service.LearnService;
import org.springframework.stereotype.Service;
import com.tangzhihe.model.LeanQueryLeanListReq;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by tengj on 2017/4/7.
 */
@Service
public class LearnServiceImpl extends BaseService<LearnResource>  implements LearnService {

    @Autowired
    private LearnResourceDao  learnResourceDao;

    @Override
    public void deleteBatch(Long[] ids) {
        Arrays.stream(ids).forEach(id->learnResourceDao.deleteByPrimaryKey(id));
    }

    @Override
    public List<LearnResource> queryLearnResouceList(Page<LeanQueryLeanListReq> page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        return learnResourceDao.queryLearnResouceList(page.getCondition());
    }
}
