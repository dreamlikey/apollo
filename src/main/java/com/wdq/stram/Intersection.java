package com.wdq.stram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 交集
 * @author wudq
 * @date 2020/7/6
 */
public class Intersection {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1L,"aa" ));
        userList.add(new User(2L,"bb" ));
        userList.add(new User(3L,"cc" ));

//        List<Long> ids = Arrays.asList(1L,3L);
        List<Long> ids = Collections.EMPTY_LIST;

        userList = userList.stream().filter(user -> ids.contains(ids)).collect(Collectors.toList());
        System.out.println(userList.size());
    }

    static class User {
        Long id;
        String name;

        public User(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }

}


