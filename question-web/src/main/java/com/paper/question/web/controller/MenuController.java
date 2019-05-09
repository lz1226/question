package com.paper.question.web.controller;

import com.paper.question.domain.util.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 菜单管理
 */
@RestController
@RequestMapping("/sys/menu")
public class MenuController {

    /**
     * 导航菜单
     */
    @GetMapping("/nav")
    public R nav(){
        System.out.println("走了导航菜单");
//        List<Map> menuList = menuService.getUserMenuList(ShiroUtils.getUserId());
        return R.ok();
    }

}
