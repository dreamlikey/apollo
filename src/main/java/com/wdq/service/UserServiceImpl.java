package com.wdq.service;


import com.wdq.apollo.entity.User;

import java.util.Optional;

/**
 * @author wudq
 * @date 2019/10/31 003116
 * @Description: TODO
 */
public class UserServiceImpl implements UserService {
    @Override
    public Optional<User> getOptionalUser(Long userId) {
        return Optional.ofNullable(this.getUserById(userId));
    }

    private User getUserById(Long userId) {
        if (userId == 1) {
            User user = new User();
            user.setId(1);
            user.setName("wudq");
            return user;
        } else {
            return null;
        }
    }
}
