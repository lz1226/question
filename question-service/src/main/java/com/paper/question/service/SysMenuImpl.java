package com.paper.question.service;

import com.paper.question.common.util.Constant;
import com.paper.question.dao.mapper.SysMenuMapper;
import com.paper.question.dao.mapper.SysUserMapper;
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

    @Resource
    private SysUserMapper sysUserMapper;

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
        return getAllMenuTreeList(parentId,sysMenu);
    }
    /**
     * 获取所有菜单 递归
     */
    private List<SysMenuDto> getAllMenuTreeList(Long parentId,SysMenuDto sysMenu){
        List<SysMenuDto> menuList = sysMenuMapper.queryListParentId(parentId,sysMenu);
         if(menuList.size() > 0){
             for(SysMenuDto item : menuList){
                 //目录
                 if(item.getType() == Constant.MenuType.CATALOG.getValue() || item.getType() == Constant.MenuType.MENU.getValue()){
                     item.setChildren(getAllMenuTreeList(item.getId(),sysMenu));
                 }
             }
         }
        return menuList;
    }

    @Override
    public List<SysMenuDto> getUserMenuList(Long userId) {
        //系统管理员，拥有最高权限
        if(userId == Constant.SUPER_ADMIN){
            return getAllMenuList(null);
        }

        //用户菜单列表
        List<Long> menuIdList = sysUserMapper.queryAllMenuId(userId);
        return getAllMenuList(menuIdList);
    }

    public List<SysMenuDto> queryListParentId(Long parentId, List<Long> menuIdList) {
        SysMenuDto sysMenu = new SysMenuDto();
        List<SysMenuDto> menuList = queryListParentId(parentId,sysMenu);
        if(menuIdList == null){
            return menuList;
        }

        List<SysMenuDto> userMenuList = new ArrayList<>();
        for(SysMenuDto menu : menuList){
            if(menuIdList.contains(menu.getId())){
                userMenuList.add(menu);
            }
        }
        return userMenuList;
    }
    /**
     * 获取所有菜单列表
     */
    private List<SysMenuDto> getAllMenuList(List<Long> menuIdList){
        //查询根菜单列表
        List<SysMenuDto> menuList = queryListParentId(0L, menuIdList);
        //递归获取子菜单
        getMenuTreeList(menuList, menuIdList);
        return menuList;
    }
    /**
     * 获取目录和菜单 递归
     */
    private List<SysMenuDto> getMenuTreeList(List<SysMenuDto> menuList, List<Long> menuIdList){
        List<SysMenuDto> subMenuList = new ArrayList<SysMenuDto>();
        for(SysMenuDto entity : menuList){
            //目录
            if(entity.getType() == Constant.MenuType.CATALOG.getValue()){
                entity.setList(getMenuTreeList(queryListParentId(entity.getId(), menuIdList), menuIdList));
            }
            subMenuList.add(entity);
        }

        return subMenuList;
    }
}
