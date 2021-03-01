package com.jiahao.training.test5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.alibaba.fastjson.annotation.JSONType;

import lombok.Data;
import org.springframework.util.CollectionUtils;

/**
 * @description:
 * @author: jiahao
 * @date: 2021/2/25
 */
@Data
//fastjson 打印字段顺序
@JSONType(orders = {"id","pid","name","children"})
public class Menu {
    //@JSONField(ordinal = 1)
    public Integer id;
    //@JSONField(ordinal = 2)
    public Integer pid;
    //@JSONField(ordinal = 3)
    public String name;
    //@JSONField(ordinal = 4)
    public List<Menu> children;
}

class MenuTree {
    private List<Menu> menuList = new ArrayList<Menu>();

    public MenuTree(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public List<Menu> buildTree(){
        List<Menu> rootMenu = getRootMenu();
        if(!CollectionUtils.isEmpty(rootMenu)){
            for(Menu menu : rootMenu){
                getChildrenMenu(menu);
            }
        }
        return rootMenu;
    }

    private List<Menu> getRootMenu(){
        if(!CollectionUtils.isEmpty(menuList)){
            return menuList.stream().filter(a->a.pid==null).collect(Collectors.toList());
        }
        return null;
    }

    private Menu getChildrenMenu(Menu menu){
        List<Menu> childList = new ArrayList<>();
        menuList.stream().filter(a->a.pid!=null).forEach(a->{
            if(a.pid.equals(menu.id)){
                childList.add(getChildrenMenu(a));
            }
        });
        menu.setChildren(childList);
        return menu;
    }
}