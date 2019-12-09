package com.wdq.service;

import com.wdq.apollo.entity.User;

import java.util.Optional;

/**
 * @author wudq
 * @date 2019/10/31 003116
 * @Description: TODO
 */
public class TestService {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        Optional<User> user = userService.getOptionalUser(3L);
        if (user.isPresent()) {
            System.out.println(user.toString());
        }
    }
}
