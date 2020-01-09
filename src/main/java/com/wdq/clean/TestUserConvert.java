package com.wdq.clean;

import org.springframework.beans.BeanUtils;

/**
 * @author wudq
 * @date 2019/12/10
 */
public class TestUserConvert {
    public static void main(String[] args) {
        UserDTO userDto = new UserDTO();
        User user = convertFor(userDto);
        User user1 = new UserDTOConvert().convert(userDto);

        User user2 = userDto.convertToUser();
        userDto = userDto.convertFrom(user2);
    }

    public static User convertFor(UserDTO userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        return user;
    }
}
