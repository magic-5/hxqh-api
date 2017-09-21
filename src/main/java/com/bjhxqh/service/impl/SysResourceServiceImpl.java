package com.bjhxqh.service.impl;


import com.bjhxqh.common.base.service.ServiceSupport;
import com.bjhxqh.mybatis.mapper.SysResourceMapper;
import com.bjhxqh.mybatis.model.po.SysResource;
import com.bjhxqh.service.SysResourceService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

/**
 * Created by Administrator on 2017-07-26.
 */
@Service
public class SysResourceServiceImpl extends ServiceSupport<SysResource> implements SysResourceService {

    public List<SysResource> getParentResources(String account){
        SysResourceMapper srmap = (SysResourceMapper)getMapper();
        return srmap.findParentResource(account);
    }
    public List<SysResource> selectByResource(SysResource sysResource){
        SysResourceMapper srmap = (SysResourceMapper)getMapper();
        Example example = new Example(SysResource.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(sysResource.getName())) {
            criteria.andLike("name", "%" + sysResource.getName() + "%");
        }
        if (StringUtil.isNotEmpty(sysResource.getMenutype())) {
            criteria.andLike("menutype", "%" + sysResource.getMenutype() + "%");
        }
        if (sysResource.getId() != null) {
            criteria.andEqualTo("id", sysResource.getId());
        }
        //分页查询
        PageHelper.startPage(sysResource.getPage(), sysResource.getRows());
        return selectByExample(example);
        //return srmap.findAllMenu();
    }
//    public List<MenuDto> getMenuByAccountAndParentId(String account,int parent,String parentName){
//        ArrayList<MenuDto> arr = new ArrayList<MenuDto>();
//        SysResourceMapper srmap = (SysResourceMapper)getMapper();
//        ArrayList<SysResource> al = srmap.findSecondaryMenuByUserAndParentId(account,parent);
//        ArrayList<SysResource> resourceList = srmap.findResourceByUserAndParentId(account,parent);
//        for(int i=0;i<al.size();i++){
//            int parentId = al.get(i).getId();
//            String menuName = al.get(i).getName();
//            MenuDto menudto = new MenuDto();
//            menudto.setName(menuName);
//            //menudto.setParentName(parentName);
//            for(int j=0;j<resourceList.size();j++){
//                SysResource sysResource = resourceList.get(j);
//                int parentValue = sysResource.getParent();
//                if(parentValue!=0&&parentValue==parentId){
//                    menudto.addMenu(sysResource);
//                }
//            }
//            if(menudto.getMenuSize()>0){
//                arr.add(menudto);
//            }
//        }
//        return  arr;
//    }
}
