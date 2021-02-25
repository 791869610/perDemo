package com.jiahao.common.core.test;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import com.fasterxml.jackson.annotation.JsonFormat.Feature;
import com.fasterxml.jackson.annotation.JsonFormat.Features;
import org.springframework.util.CollectionUtils;

/**
 * @description:
 * @author: jiahao
 * @date: 2021/2/25
 */
public class test {
    private static List<Menu> yy(Menu menu,List<Menu> result){
        Integer pid = menu.getPid();
        if(CollectionUtils.isEmpty(result)){
            result = new ArrayList<>();
        }
        if(pid==null){
            result.add(menu);
        }else{
            result.forEach(p->{
                List<Menu> children = p.getChildren();
                if(pid.equals(p.getId())){
                    children.add(menu);
                }else{
                    yy(menu,p.getChildren());
                }
            });
        }
        return result;
    }

    public static void main(String[] args) {
        String json= "[{'id':1,'pid':null,'name':'name1'},{'id':2,'pid':1,'name':'name2'},{'id':3,'pid':1,'name':'name3'},"
            + "{'id':4,'pid':2,'name':'name4'},{'id':5,'pid':null,'name':'name5'},{'id':6,'pid':5,'name':'name6'}]";
        List<Menu> menuList = JSONArray.parseArray(json, Menu.class);
        MenuTree menuTree = new MenuTree(menuList);
        List<Menu> menus = menuTree.buildTree();
        System.out.println(menus);
        String str = JSON.toJSONString(menus);
        System.out.println(str);
    }


    //[
    //    (id=1, pid=null, name=name1, children=[
    //        (id=2, pid=1, name=name2, children=[
    //            (id=4, pid=2, name=name4, children=[])]),
    //    (id=3, pid=1, name=name3, children=[])]),
    //    (id=5, pid=null, name=name5, children=[
    //        (id=6, pid=5, name=name6, children=[])])]

    //test a
    //test b
    //test c
}
