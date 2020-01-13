package com.wdq.clean;

import org.springframework.beans.BeanUtils;

import lombok.Data;

@Data
public class UserDTO {
    private String username;
    private Integer age;

    /**
     * 转换为
     * @return
     */
    public User convertToUser() {
        UserDTOConverter converter = new UserDTOConverter();
        return converter.doForward(this);
    }

    /**
     * 转换自
     * @param user
     * @return
     */
    public UserDTO convertFrom(User user) {
        UserDTOConverter converter = new UserDTOConverter();
        return converter.doBackward(user);
    }

    private static class UserDTOConverter implements Converter<User, UserDTO> {

        @Override
        public User doForward(UserDTO userDTO) {
            User user = new User();
            BeanUtils.copyProperties(userDTO, user);
            return user;
        }

        @Override
        public UserDTO doBackward(User user) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user, userDTO);
            return userDTO;
        }
    }
}
