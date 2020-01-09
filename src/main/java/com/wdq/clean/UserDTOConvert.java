package com.wdq.clean;

import org.springframework.beans.BeanUtils;

/**
 * @author wudq
 * @date 2019/12/10 001018
 * @Description: TODO
 */
public class UserDTOConvert implements DTOConvert<User, UserDTO> {
    @Override
    public User convert(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return user;
    }
}
