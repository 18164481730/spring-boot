package com.tangzhihe.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.tangzhihe.domain.LearnResource;
import com.tangzhihe.model.LearnResourceModel;
import com.tangzhihe.service.LearnService;
import com.tangzhihe.util.AjaxObject;
import com.tangzhihe.util.Page;

/** 教程页面
 * Created by tengj on 2017/3/13.
 */
@Controller
@RequestMapping("/learn")
public class LearnController  extends AbstractController{
    @Autowired
    private LearnService learnService;

    @RequestMapping("")
    public String learn(Model model){
        model.addAttribute("ctx", getContextPath()+"/");
        return "learn-resource";
    }

    /**
     * 查询教程列表
     * @param page
     * @return
     */
    @RequestMapping(value = "/queryLeanList",method = RequestMethod.POST)
    @ResponseBody
    public AjaxObject queryLearnList(Page<LearnResourceModel> page){
        List<LearnResource> learnList=learnService.queryLearnResouceList(page);
        PageInfo<LearnResource> pageInfo =new PageInfo<LearnResource>(learnList);
        return AjaxObject.ok().put("page", pageInfo);
    }
    
    /**
     * 新添教程
     * @param learnResource
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public AjaxObject addLearnResource(@RequestBody LearnResource learnResource) {
    	int n = learnService.save(learnResource);
    	if(n == 1) {
    		return AjaxObject.ok();
    	} else {
    		return AjaxObject.error();
    	}
    }
    
    /**
     * 更新教程
     * @param learnResource
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public AjaxObject updateLearnResource(@RequestBody LearnResource learnResource) {
    	int n = learnService.update(learnResource);
    	if(n == 1) {
    		return AjaxObject.ok();
    	} else {
    		return AjaxObject.error();
    	}
    }
    
    /**
     * 删除教程
     * @param learnResource
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public AjaxObject deleteLearnResource(@RequestBody Long[] ids) {
    	learnService.delete(ids);
    	return AjaxObject.ok();
    }
}

















