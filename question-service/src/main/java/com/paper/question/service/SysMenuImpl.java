package com.paper.question.service;

import com.paper.question.common.util.Constant;
import com.paper.question.dao.mapper.SysMenuMapper;
import com.paper.question.domain.dto.SysMenuDto;
import com.paper.question.domain.entity.SysMenu;
import com.paper.question.interfaces.ISysMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SysMenuImpl implements ISysMenuService{

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public SysMenuDto findById(long id) {
        return sysMenuMapper.findById(id);
    }

    @Override
    public int create(SysMenu sysMenu) {
        return  sysMenuMapper.insertSelective(sysMenu);
    }

    @Override
    public int edit(SysMenu sysMenu) {
        return sysMenuMapper.updateByPrimaryKeySelective(sysMenu);
    }

    @Override
    public int delete(long id) {
        return sysMenuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<SysMenuDto> treeMenuList(Long menuId, SysMenuDto sysMenu) {
        List<SysMenuDto>   menuList =  queryListParentId(menuId,sysMenu);
        return menuList;
    }

    @Override
    public int batchDelete(Long[] ids) {

        return sysMenuMapper.batchDelete(ids);
    }


//    public void getParent(ActivityAndOrderDto activityAndOrderDto,Integer activityId){
//        activityAndOrderDto.setCustom(getChild(activityId,0));
//    }
//    //根据 pid 查到第一个  根据第一个的id查找他下边的内容
//    public List<CustomDto>  getChild(Integer activityId,Integer pid){
//        List<CustomDto> childCustoms = customMapper.listAvailable(activityId,pid);
//        for (CustomDto item : childCustoms) {
//            //根据父级的id 查询字集下边的内容  一级一级的往下找
//            item.setChildren(getChild(activityId,item.getId()));
//        }
//        return childCustoms;
//    }

    public List<SysMenuDto> queryListParentId(Long parentId,SysMenuDto sysMenu) {
        return getAllMenuTreeList(parentId);
    }
    /**
     * 获取所有菜单 递归
     */
    private List<SysMenuDto> getAllMenuTreeList(Long parentId){
        List<SysMenuDto> menuList = sysMenuMapper.queryListParentId(parentId);
        for(SysMenuDto item : menuList){
            //目录
            if(item.getType() == Constant.MenuType.CATALOG.getValue() || item.getType() == Constant.MenuType.MENU.getValue()){
                    item.setChildren(getAllMenuTreeList(item.getId()));
            }
        }
        return menuList;
    }
}
