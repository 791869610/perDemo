package com.jiahao.training.demo.demo2.test2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class test {

    public static void main(String[] args){


        List<User> list = new ArrayList<User>();

        User user1 = User.builder().age(1).build();
        User user2 = User.builder().age(15).build();
        User user3 = User.builder().age(11).build();
        User user4 = User.builder().age(3).build();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

//        int size = list.size();
//        for (User user : list){
//            int age = user.getAge();
//            if(age<10){
//                list.remove(user);
//            }
//        }

//        for(int i = 0;i<list.size();i++){
//            int age = list.get(i).getAge();
//            if(age<10){
//                list.remove(i);
//            }
//        }
        Iterator<User> users = list.iterator();
        while (users.hasNext()){
            User next = users.next();
            if(next.getAge()<10){
                users.remove();
            }
        }
        list.removeIf(next -> next.getAge() < 10);
        System.out.println(list);
    }
}
