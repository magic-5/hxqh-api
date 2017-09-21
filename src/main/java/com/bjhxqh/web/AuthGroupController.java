package com.bjhxqh.web;


import com.bjhxqh.mybatis.model.po.SysAuthgroup;
import com.bjhxqh.service.SysAuthGroupService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Administrator on 2017-07-20.
 */
@Controller
@RequestMapping(value = "/authgroup")
public class AuthGroupController {
    @Autowired
    private SysAuthGroupService authgroupService;

    private String page_list = "test";

    private String redirect_list = "redirect:/authgroup/list";

    @RequestMapping(value = {"list", ""})
    public ModelAndView getList(SysAuthgroup authgroup) {
        ModelAndView result = new ModelAndView(page_list);
        List<SysAuthgroup> authgroupList = authgroupService.selectByAuthGroup(authgroup);
        result.addObject("pageInfo", new PageInfo<SysAuthgroup>(authgroupList));
        result.addObject("queryParam", authgroup);
        result.addObject("page", authgroup.getPage());
        result.addObject("rows", authgroup.getRows());
        return result;
    }

    @RequestMapping(value = "view", method = RequestMethod.GET)
    public ModelAndView view(SysAuthgroup authgroup) {
        ModelAndView result = new ModelAndView();
        if (authgroup.getId() != null) {
            authgroup = authgroupService.selectByKey(authgroup.getId());
        }
        result.addObject("country", authgroup);
        return result;
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ModelAndView save(SysAuthgroup authgroup) {
        ModelAndView result = new ModelAndView(redirect_list);
        if (authgroup.getId() != null) {
            authgroupService.updateAll(authgroup);
        } else {
            authgroupService.save(authgroup);
        }
        return result;
    }

    @RequestMapping("delete")
    public String delete(Integer id) {
        authgroupService.delete(id);
        return redirect_list;
    }
}
