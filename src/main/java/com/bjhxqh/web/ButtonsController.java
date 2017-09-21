package com.bjhxqh.web;


import com.bjhxqh.mybatis.model.po.SysButtons;
import com.bjhxqh.service.SysButtonsService;
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
@RequestMapping(value = "/buttons")
public class ButtonsController {
    @Autowired
    private SysButtonsService buttonsService;

    private String page_list = "test";

    private String redirect_list = "redirect:/buttons/list";

    @RequestMapping(value = {"list", ""})
    public ModelAndView getList(SysButtons button) {
        ModelAndView result = new ModelAndView(page_list);
        List<SysButtons> buttonList = buttonsService.selectByButton(button);
        result.addObject("pageInfo", new PageInfo<SysButtons>(buttonList));
        result.addObject("queryParam", button);
        result.addObject("page", button.getPage());
        result.addObject("rows", button.getRows());
        return result;
    }

    @RequestMapping(value = "view", method = RequestMethod.GET)
    public ModelAndView view(SysButtons button) {
        ModelAndView result = new ModelAndView();
        if (button.getId() != null) {
            button = buttonsService.selectByKey(button.getId());
        }
        result.addObject("country", button);
        return result;
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ModelAndView save(SysButtons button) {
        ModelAndView result = new ModelAndView(redirect_list);
        if (button.getId() != null) {
            buttonsService.updateAll(button);
        } else {
            buttonsService.save(button);
        }
        return result;
    }

    @RequestMapping("delete")
    public String delete(Integer id) {
        buttonsService.delete(id);
        return redirect_list;
    }
}