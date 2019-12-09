package com.wdq.service;


import com.wdq.apollo.entity.User;

import java.util.Optional;

/**
 * @author wudq
 * @date 2019/10/31 003116
 * @Description: TODO
 */
public interface UserService {
    Optional<User> getOptionalUser(Long userId);
}
